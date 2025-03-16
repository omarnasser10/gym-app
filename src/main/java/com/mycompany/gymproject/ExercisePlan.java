package com.mycompany.gymproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExercisePlan {
    private String filename = "ExercisePlan.txt";
    private static int lastExercisePlanID = loadLastID("lastExercisePlanID.txt");
    protected static FileHandler fileHandler = new FileHandler("myDirectory");
    int planID;
    String descriprion;
    String duration;
    String exercises;


    public ExercisePlan(String descriprion, String duration, String exercises) {
        this.planID = ++lastExercisePlanID; // Increment and assign
        saveLastID("lastExercisePlanID.txt"); // Save updated ID
        this.descriprion = descriprion;
        this.duration = duration;
        this.exercises = exercises;
        fileHandler.appendToFile(filename, this.display() + "\n");
    }

    public static int loadLastID(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            return line != null ? Integer.parseInt(line) : 0; // Default to 0 if file is empty
        } catch (IOException e) {
            return 0; // Default to 0 if file doesn't exist
        }
    }

    private void saveLastID(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(String.valueOf(lastExercisePlanID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean search_by_id(String id) {
        if (fileHandler.searchContent(filename, "planID=" + id))
            return true;
        else return false;
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ExercisePlan{" + "planID=" + planID + ", descriprion=" + descriprion + ", duration=" + duration + ", exercises=" + exercises + '}';
    }


    public String display() {
        return "planID=" + planID + ", descriprion=" + descriprion + ", duration=" + duration + ", exercises=" + exercises;
    }

    public static ExercisePlan readExercisePlanFromFile(String filename, String eID) throws IOException {

        if (fileHandler.searchContent(filename, eID)) {
            String descriprion = "", duration = "", exercises = "";
            int planID = 0;
            String line = fileHandler.readLineById(filename, eID);

            if (line != null) {
                // إذا تم العثور على السطر الذي يحتوي على trainerID، نقوم باستخراج البيانات منه
                String[] parts = line.split(","); // نفصل النصوص بناءً على الفواصل
                for (String part : parts) {
                    part = part.trim(); // إزالة الفراغات الزائدة
                    if (part.startsWith("descriprion=")) {
                        descriprion = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("duration=")) {
                        duration = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("exercises=")) {
                        exercises = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("planID=")) {
                        planID = Integer.parseInt(part.split("=")[1].trim());
                    }
                }

                ExercisePlan e = new ExercisePlan(descriprion, duration, exercises);
                e.setPlanID(planID);
                return e;
            } else {
                System.out.println("Trainer with ID " + eID + " not found.");
                return null;
            }
        } else return null;
    }


}



