package com.mycompany.gymproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Equipment {
    private int equipid;
    private static int lastEquipmentID = loadLastID("lastEquipmentID.txt");
    private String name;
    private boolean isavail;


    public Equipment(String name, boolean isavail) {
        this.equipid = ++lastEquipmentID; // Increment and assign
        //saveLastID("lastEquipmentID.txt"); // Save updated ID
        this.name = name;
        this.isavail = isavail;

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
            bw.write(String.valueOf(lastEquipmentID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getEquipid() {
        return equipid;
    }

    public void setEquipid(int equipid) {
        this.equipid = equipid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsavail() {
        return isavail;
    }

    public void setIsavail(boolean isavail) {
        this.isavail = isavail;
    }

    @Override
    public String toString() {
        return
                " equipID=" + equipid +
                        ", name=" + name +
                        ", isavail=" + isavail;
    }


}

