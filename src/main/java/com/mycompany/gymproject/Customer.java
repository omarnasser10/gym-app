package com.mycompany.gymproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Customer extends Person {
    private static String filename = "Membership.txt";
    private static int lastCustomerID = loadLastID("lastCustomerID.txt");
    protected static FileHandler fileHandler = new FileHandler("myDirectory");
    private int customerID;
    private static int count = 1;
    private double height, weight;
    private Trainer trainer;
    private ExercisePlan exerciseplan;
    private Membership membership;

    public Customer(String name, int age, String phone, String email, double height, double weight, String startDate, String endDate, String type, boolean isactive) {
        super(name, phone, email, age);
        this.height = height;
        this.weight = weight;
        this.customerID = ++lastCustomerID; // Increment and assign
       // saveLastID("lastCustomerID.txt");
        this.membership = new Membership(startDate, endDate, type, isactive);

    }

    public static void incrementcount() {
        count++;
    }

    public static int getCount() {
        return count;
    }


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public ExercisePlan getExerciseplan() {
        return this.exerciseplan;
    }

    public void setExerciseplan(ExercisePlan exerciseplan) {
        this.exerciseplan = exerciseplan;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", customerID=" + customerID +
                ", height=" + height +
                ", weight=" + weight +
                ", exerciseplan{ " + this.getExerciseplan() + " }"
                + ", Membership{ " + this.getMembership() + " }"
                ;
    }

    private static int loadLastID(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            return line != null ? Integer.parseInt(line) : 0; // Default to 0 if file is empty
        } catch (IOException e) {
            return 0; // Default to 0 if file doesn't exist
        }
    }

    public static void saveLastID(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(String.valueOf(lastCustomerID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Customer readCustomerFromFile(String filename, String customerId) throws IOException {

        if (new CustomerManager().search_by_id(customerId)) {
            String name = "", phone = "", email = "";
            int age = 0;
            double weight = 0.0, height = 0.0;
            String line = new CustomerManager().show_by_id(customerId);

            if (line != null) {
                // إذا تم العثور على السطر الذي يحتوي على trainerID، نقوم باستخراج البيانات منه
                String[] parts = line.split(","); // نفصل النصوص بناءً على الفواصل
                for (String part : parts) {
                    part = part.trim(); // إزالة الفراغات الزائدة
                    if (part.startsWith("name=")) {
                        name = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("phone=")) {
                        phone = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("email=")) {
                        email = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("age=")) {
                        age = Integer.parseInt(part.split("=")[1].trim());
                    } else if (part.startsWith("weight=")) {
                        weight = Double.parseDouble(part.split("=")[1].trim());
                    } else if (part.startsWith("height=")) {
                        height = Double.parseDouble(part.split("=")[1].trim());
                    }
                }

                String s = new CustomerManager().showMemberShipOfCustomerId(customerId);
                String m = new CustomerManager().showExercisePlanOfCustomerId(customerId);
                String t = s.substring(33, 34);
                String t2 = m.substring(33, 34);
                Membership membership = Membership.readMembershipFromFile("Membership.txt", t);
                ExercisePlan exercisePlan = ExercisePlan.readExercisePlanFromFile("ExercisePlan.txt", t2);

                assert membership != null;
                Customer c = new Customer(name, age, phone, email, height, weight, membership.getStartDate(), membership.getEndDate(), membership.getType(), membership.isIsactive());
                c.setExerciseplan(exercisePlan);

                return c;
            } else {
                System.out.println("Customer with ID " + customerId + " not found.");
                return null;
            }
        } else return null;
    }
}