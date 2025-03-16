package com.mycompany.gymproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public abstract class Manager extends Employee {
    static String filename = "Manager.txt";
    private static int lastManagerID = loadLastID("lastManagerID.txt"); // Load last used ID
    private int managerid;
    private static int count = 1;
    protected static FileHandler fileHandler = new FileHandler("myDirectory");

    public Manager() {
       // super();

    }

    public Manager(String name, String phone, String email, int age, double salary, String hiringDate) {
        super(name, phone, email, age, salary, hiringDate);
        this.managerid = ++lastManagerID; // Increment and assign ID
//        saveLastID("lastManagerID.txt"); // Save updated ID
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
            bw.write(String.valueOf(lastManagerID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void add(Object ob) throws IOException;

    public abstract boolean search_by_id(String id);

    public abstract void update(int id, String old, String New);

    public abstract void delete(String id);

    public static void delete_Manager(String id) {
        List<String> S = new FileHandler("myDirectory").readLines("login.txt");
        for (String x : S) {
            if (x.contains(id) && x.contains("Manager")) {
                fileHandler.deleteLineById("login.txt", x);
            }
        }
        fileHandler.deleteLineById(filename, "managerid=" + id);
    }

    public static boolean search_Manager_by_id(String id) {
        if (fileHandler.searchContent(filename, "managerid=" + id))
            return true;
        else return false;
    }

    public abstract String show_by_id(String id);

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    public static void add_Manager(Manager item) {
        if (item instanceof CustomerManager) {
            System.out.println("Customermanager " + ((CustomerManager) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((CustomerManager) item)) + "\n");
            Manager.saveLastID("lastManagerID.txt"); // Save updated ID
        } else if (item instanceof TrainerManager) {
            System.out.println("Trainermanager " + ((TrainerManager) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((TrainerManager) item)) + "\n");
            Manager.saveLastID("lastManagerID.txt"); // Save updated ID
        } else if (item instanceof EquipmentManager) {
            System.out.println("EquipmentManager " + ((EquipmentManager) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((EquipmentManager) item)) + "\n");
            Manager.saveLastID("lastManagerID.txt"); // Save updated ID
        } else {
            System.out.println("ScheduleManager " + ((ScheduleManager) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((ScheduleManager) item)) + "\n");
            Manager.saveLastID("lastManagerID.txt"); // Save updated ID
        }
    }


    public void list() {
        System.out.println(fileHandler.readLines(filename));
    }

    @Override
    public String toString() {
        return super.toString() +
                "managerid=" + managerid;
    }
}


