package com.mycompany.gymproject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TrainerManager extends Manager{
    private String filename="Trainers.txt";
    private final static String department="TrainerManager";

    public TrainerManager(){
        super();

    }
    public TrainerManager(String name, String phone, String email, int age, double salary, String hiringDate){
        super(name, phone, email, age, salary, hiringDate);
    }

    @Override
    public void add(Object item) {
        if (item instanceof Trainer) {
            System.out.println("Trainer " + ((Trainer) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((Trainer) item))+"\n");
            Trainer.saveLastID("lastTrainerID.txt");
        } else {
            System.out.println("Only Trainer can be added.");
        }
    }

    public boolean search_by_id(String id){
        if(fileHandler.searchContent(filename,"trainerID="+id))
            return true;
        else return false;
    }

    public void update(int id,String old,String New){
        fileHandler.update(filename,"trainerID="+id ,old,New);
    }

    public void delete(String id){
        List<String> S=new FileHandler("myDirectory").readLines("login.txt");
        for(String x:S){
            if(x.contains(id) && x.contains("Trainer")){
                fileHandler.deleteLineById("login.txt",x);
            }
        }
        fileHandler.deleteLineById(filename,"trainerID="+id);
    }

    public String show_by_id(String id){
        if(search_by_id(id)){
            return fileHandler.readLineById(filename,"trainerID="+id);
        }
        else{
            return "can not found thid id";
        }
    }

    public String assigntrainer(String tid,String cid){
        if(!search_by_id(tid))
            return "trainerid not found";
        if(!new CustomerManager().search_by_id(cid))
            return "customerid not found";
        if(show_customers_of_trainer(tid).contains(cid))
            return "this customer already assign to this trainer";
        return update_customerlist(tid,cid);
    }

    public String update_customerlist(String t, String c) {
        List<String> lines = fileHandler.readLines(filename);
        String msg = "No updates were made."; // رسالة افتراضية في حال عدم وجود تغييرات
        boolean isUpdated = false; // لتتبع إذا حدث تغيير

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.contains("trainerID=" + t)) {
                String oldCustomers = show_customers_of_trainer(t);

                if (!oldCustomers.contains(String.valueOf(c))) {
                    // تعديل قائمة العملاء
                    oldCustomers = oldCustomers.isEmpty() ? String.valueOf(c) : oldCustomers + ", " + c;
                    String updatedLine = line.replaceAll("customers\\{[^}]*\\}", "customers{ [" + oldCustomers + "] }");

                    // تحديث السطر في القائمة
                    lines.set(i, updatedLine);

                    // تحديث الحالة
                    isUpdated = true;
                    break;
                }
            }
        }

        if (isUpdated) {
            // تحديث الملف إذا حدث تغيير
            String updatedContent = String.join(System.lineSeparator(), lines);
            fileHandler.writeFile(filename, updatedContent);
            msg = "Customer list updated successfully for trainerID=" + t;
        }

        return msg;
    }


    public String show_customers_of_trainer(String id){
        if(!search_by_id(id))
            return "this trainer id not found";
        List<String> lines = fileHandler.readLines(filename);
        for (String line : lines) {
            if (line.contains("trainerID=" + id)) {
                int startIndex = line.indexOf("[") + 1;
                int endIndex = line.indexOf("]");
                if (startIndex > 0 && endIndex > startIndex) {
                    return line.substring(startIndex, endIndex).trim();
                }
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return super.toString()+" , department='" + department;
    }

}