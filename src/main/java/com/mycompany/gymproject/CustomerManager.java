package com.mycompany.gymproject;
import java.io.IOException;
import java.util.List;
public class CustomerManager extends Manager{
    private String filename="Customers.txt";
    private final static String department="CustomerManager";

    public CustomerManager(){
        super();
    }
    public CustomerManager(String name, String phone, String email, int age, double salary, String hiringDate){
        super(name, phone, email, age, salary, hiringDate);
    }

    @Override
    public void add(Object item){
        if (item instanceof Customer){
            System.out.println("Customer " + ((Customer) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((Customer) item)) + "\n");
            fileHandler.appendToFile("Membership.txt",String.valueOf(((Membership) ((Customer) item).getMembership()))+"\n");
            Customer.saveLastID("lastCustomerID.txt");
            Membership.saveLastID("lastMembershipID.txt");
        } else {
            System.out.println("Only customers can be added.");
        }
    }

    public boolean customerExists(int customerID) {
        List<String> lines = fileHandler.readLines(filename);
        for (String line : lines) {
            if (line.contains("customerID=" + customerID)) {
                return true;  // Return true if customerID exists in the file
            }
        }
        return false;  // Return false if customerID doesn't exist
    }


    public boolean search_by_id(String id){
        if(fileHandler.searchContent(filename,"customerID="+id))
            return true;
        else return false;
    }

    public void update(int id,String old,String New){
        fileHandler.update(filename,"customerID="+id ,old,New);
    }

    public void delete(String id){
        List<String> S=new FileHandler("myDirectory").readLines("login.txt");
        for(String x:S){
            if(x.contains(id) && x.contains("Customer")){
                fileHandler.deleteLineById("login.txt",x);
            }
        }
        fileHandler.deleteLineById(filename,"customerID="+id);
    }

    public String show_by_id(String id){
        if(search_by_id(id)){
            return fileHandler.readLineById(filename,"customerID="+id);
        }
        else{
            return "can not found thid id";
        }
    }

    public void update_exerciseplan( String customerID) throws IOException {
        List<String> lines = fileHandler.readLines(filename);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("customerID=" + customerID)) {
                String updatedLine = line.replaceAll("exerciseplan\\{[^}]*\\}", "exerciseplan{" + ExercisePlan.readExercisePlanFromFile("ExercisePlan.txt",""+ExercisePlan.loadLastID("lastExercisePlanID.txt")) + "}");
                lines.set(i, updatedLine);
                break;
            }
        }
        String updatedContent = String.join("\n", lines);
        fileHandler.writeFile(filename, updatedContent);
    }


    public String showExercisePlanOfCustomerId(String id) {
        List<String> lines = fileHandler.readLines(filename);
        String result = ""; // Variable to hold the result

        for (String line : lines) {
            if (search_by_id(id)) {
                int startIndex = line.indexOf("exerciseplan{");
                if (startIndex != -1) {
                    int endIndex = line.indexOf("}", startIndex) + 1; // Find the end of the exercise plan
                    if (endIndex > startIndex) {
                        String exercisePlan = line.substring(startIndex, endIndex);
                        if (exercisePlan.contains("null")) {
                            result = "Exercise plan not available for CustomerID " + id;
                        } else {
                            result = exercisePlan;
                        }
                    } else {
                        result = "Invalid exercise plan format for CustomerID " + id;
                    }
                    break; // Exit the loop once the exercise plan is processed
                } else {
                    result = "Exercise plan not found for CustomerID " + id;
                    break;
                }
            }
        }

        if (result.isEmpty()) {
            result = "CustomerID " + id + " not found.";
        }

        return result;
    }

    public String showMemberShipOfCustomerId(String id) {
        List<String> lines = fileHandler.readLines(filename);
        String result = "";  // Variable to hold the result

        for (String line : lines) {
            if (search_by_id(id)) {
                int startIndex = line.indexOf("Membership{");
                if (startIndex != -1) {
                    result = line.substring(startIndex);
                    break;  // Exit the loop once the membership is found
                } else {
                    result = "Membership not found for CustomerID " + id;
                    break;
                }
            }
        }

        if (result.isEmpty()) {
            result = "CustomerID " + id + " not found.";
        }

        return result;
    }


    public void createMembership(String startDate, String endDate, String type, boolean isactive, Customer customer) {
        if (customer.getMembership() == null) {
            Membership membership = new Membership(startDate, endDate, type, isactive);
            customer.setMembership(membership);
            System.out.println("Membership created for customer: " + customer.getName());
        } else {
            System.out.println("Customer already has a membership.");
        }

        update_membership(customer);
    }

    public boolean check_membership_by_id(String Customerid) {
        boolean membershipFound = false;
        List<String> lines = fileHandler.readLines(filename);
        for (String line : lines)
            if (search_by_id(Customerid)) {
                int startIndex = line.indexOf("Membership{");
                if (startIndex != -1) {
                    String membershipDetails = line.substring(startIndex);
                    if (membershipDetails.contains("isactive='true'"))
                        membershipFound = true;
                    else if(membershipDetails.contains("isactive='false'"))
                        membershipFound = false;
                }
            }
        return membershipFound;
    }

    public String renew_membership(String Customerid, boolean newStatus, String newEndDate){
        if(search_by_id(Customerid)){
            if(!check_membership_by_id(Customerid)) {
                List<String> lines = fileHandler.readLines(filename);
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);

                    if (line.contains("customerID=" + Customerid)) {
                        String updatedLine = line.replaceAll("isactive='[^']*'", "isactive='" + newStatus + "'")
                                .replaceAll("endDate='[^']*'", "endDate='" + newEndDate + "'");

                        lines.set(i, updatedLine);
                        break;
                    }

                }
                String updatedContent = String.join("\n", lines);
                delete(Customerid);
                fileHandler.writeFile(filename, updatedContent);
                return "Membership renewed successfully";
            }
            return "membership is already active";
        }
        return "CustomerID " + Customerid + " not found.";
    }


    public void update_membership(Customer customer) {
        List<String> lines = fileHandler.readLines(filename);
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains("customerID=" + customer.getCustomerID())) {
                String updatedLine = line.replaceAll("Membership[^}]*}", "Membership{" + customer.getMembership().toString() + "}");
                lines.set(i, updatedLine);
                break;
            }
        }

        fileHandler.writeFile(filename, String.join("\n", lines));
    }

    @Override
    public String toString() {
        return super.toString()+" , department='" + department;
    }
}



