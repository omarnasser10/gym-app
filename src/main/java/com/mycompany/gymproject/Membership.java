package com.mycompany.gymproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Membership {
    private String filename = "Membership.txt";
    protected static FileHandler fileHandler = new FileHandler("myDirectory");
    private int membershipID;
    private static int lastMembershipID = loadLastID("lastMembershipID.txt");
    private String startDate;
    private String endDate;
    private String type;
    private boolean isactive;


    public Membership(String startDate, String endDate, String type, boolean isactive) {
        this.membershipID = ++lastMembershipID; // Increment and assign
       // saveLastID("lastMembershipID.txt"); // Save updated ID
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.isactive = isactive;
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
            bw.write(String.valueOf(lastMembershipID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(int membershipID) {
        this.membershipID = membershipID;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return
                "membershipID=" + membershipID  +
                        ", startDate=" + startDate +
                        ", endDate=" + endDate +
                        ", type=" + type +
                        ", isactive=" + isactive;
    }

    public String display() {
        return
                "membershipID=" + membershipID + ", startDate=" + startDate + ", endDate=" + endDate + ", type=" + type + ", isactive=" + isactive;
    }

    public static Membership readMembershipFromFile(String filename, String mID) throws IOException {

        if (fileHandler.searchContent(filename, mID)) {
            String startDate = "", endDate = "", type = "";
            int membershipID = 0;
            boolean isactive = false;
            String line = fileHandler.readLineById(filename, mID);

            if (line != null) {
                // إذا تم العثور على السطر الذي يحتوي على trainerID، نقوم باستخراج البيانات منه
                String[] parts = line.split(","); // نفصل النصوص بناءً على الفواصل
                for (String part : parts) {
                    part = part.trim();
                    if (part.startsWith("membershipID=")) {
                        membershipID = Integer.parseInt(part.split("=")[1].trim());
                    }// إزالة الفراغات الزائدة
                    else if (part.startsWith("startDate=")) {
                        startDate = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("endDate=")) {
                        endDate = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("type=")) {
                        type = part.split("=")[1].replace("'", "").trim();
                    } else if (part.startsWith("isactive=")) {
                        isactive = Boolean.parseBoolean(part.split("=")[1].trim());
                    }
                }

                Membership e = new Membership(startDate, endDate, type, isactive);
                e.setMembershipID(membershipID);
                return e;
            } else {
                System.out.println("Trainer with ID " + mID + " not found.");
                return null;
            }
        } else return null;
    }

}