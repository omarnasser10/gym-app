package com.mycompany.gymproject;
import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Trainer extends Employee{
    private static int lastTrainerID = loadLastID("lastTrainerID.txt");
    private int trainerID;
    private static int count=1;
    private String specialty;
    private int experienceYears;
    private List<Integer> customers=new ArrayList<>();

    public Trainer(String name, int age, String phone, String email, String specialty,int experienceYears, double salary, String hiringDate) {
        super(name, phone, email, age,salary,hiringDate);
        this.experienceYears=experienceYears;
        this.trainerID = ++lastTrainerID; // Increment and assign
        //saveLastID("lastTrainerID.txt"); // Save updated ID
        this.specialty = specialty;
        count++;
    }

    public Trainer() {
    }

    public static int loadLastID(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            return line != null ? Integer.parseInt(line) : 0; // Default to 0 if file is empty
        } catch (IOException e) {
            return 0; // Default to 0 if file doesn't exist
        }
    }

    public static void saveLastID(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(String.valueOf(lastTrainerID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        return  count;
    }

    public static void incrementcount(){
        count++;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(int trainerID) {
        this.trainerID = trainerID;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setCustomer(int c){
        this.customers.add(c);
    }

    public List<Integer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Integer> customers) {
        this.customers = customers;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYearss(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void create_plane_to_customer(String descriprion, String duration, String exercises, String customerid) throws IOException {
        CustomerManager cm=new CustomerManager();
        ExercisePlan e=new ExercisePlan(descriprion,duration,exercises);
        cm.update_exerciseplan(customerid);
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", trainerID=" + trainerID +
                ", specialty=" + specialty +
                ", experienceYears=" + experienceYears
                +", customers{ "+customers+" }";
    }

    // Method to read trainer from file
    public static Trainer readTrainerFromFile(String filename, String trainerID) throws IOException {

        if(new TrainerManager().search_by_id(trainerID)){
            String name = "", phone = "", email = "", hiringDate = "", specialty = "";
            int age = 0, experienceYears = 0;
            double salary = 0.0;
            ArrayList<Integer> customers = new ArrayList<>();

            String line = new TrainerManager().show_by_id(trainerID);

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
                    } else if (part.startsWith("salary=")) {
                        salary = Double.parseDouble(part.split("=")[1].trim());
                    } else if (part.startsWith("hiringDate=")) {
                        hiringDate = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("specialty=")) {
                        specialty = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("experienceYears=")) {
                        experienceYears = Integer.parseInt(part.split("=")[1].trim());
                    } else if (part.startsWith("customers{")) {
                        String c = new TrainerManager().show_customers_of_trainer(trainerID);
                        if (!c.equals("")) {
                            String s[] = c.split(",");
                            try {
                                for (int i = 0; i < s.length; i++) {
                                    customers.add(Integer.parseInt(s[i]));
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error parsing customer ID: ");
                            }
                        }
                    }


                }

                // إنشاء كائن Trainer مع البيانات المستخرجة
                Trainer trainer = new Trainer(name, age, phone, email, specialty, experienceYears, salary, hiringDate);
                trainer.setTrainerID(Integer.parseInt(trainerID));
                trainer.setCustomers(customers);
                return trainer;
            } else {
                // إذا لم يتم العثور على trainerID
                System.out.println("Trainer with ID " + trainerID + " not found.");
                return null;
            }

        }
        else return null;
    }


}


