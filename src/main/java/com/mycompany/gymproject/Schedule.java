package com.mycompany.gymproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Schedule {
    private int scheduleId;
    private static int lastScheduleID = loadLastID("lastScheduleID.txt"); // Load last used ID
    private String date;
    private String startTime;
    private String endTime;
    private int customerId;
    private int gymHallId;
    private int trainerId;


    public Schedule(String date, String startTime, String endTime, int customerId, int trainerId, int gymHallId) {
        this.scheduleId = ++lastScheduleID; // Increment and assign ID
        //saveLastID("lastScheduleID.txt"); // Save updated ID
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.customerId = customerId;
        this.gymHallId = gymHallId;
        this.trainerId = trainerId;
       
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
            bw.write(String.valueOf(lastScheduleID)); // Save the last used ID
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getStartTime() {
        return startTime;
    }


    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCustomerId() {
        return customerId;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public int getGymHallId() {
        return gymHallId;
    }


    public void setGymHallId(int gymHallId) {
        this.gymHallId = gymHallId;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public String toString() {
        return
                " scheduleID=" + scheduleId +
                        ", date='" + date + '\'' +
                        ", startTime='" + startTime + '\'' +
                        ", endTime='" + endTime + '\'' +
                        ", customerId=" + customerId +
                        ", trainerId=" + trainerId +
                        ", gymHallId=" + gymHallId ;
    }
}

