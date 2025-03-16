package com.mycompany.gymproject;
import java.util.ArrayList;
import java.util.List;
public class ScheduleManager extends Manager{
    private String filename="Schedule.txt";
    private final static String department="ScheduleManager";

    public ScheduleManager(){
        super();
    }
    public ScheduleManager(String name, String phone, String email, int age, double salary, String hiringDate) {
        super(name, phone, email, age, salary, hiringDate);
    }


    @Override
    public void add(Object item) {
        if (item instanceof Schedule) {
            System.out.println("Schedule " + ((Schedule) item).getScheduleId() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((Schedule) item))+"\n");
            Schedule.saveLastID("lastScheduleID.txt");
        } else {
            System.out.println("Only Schedule can be added.");
        }
    }

    public boolean search_by_id(String id){
        if(fileHandler.searchContent(filename,"scheduleID="+id))
            return true;
        else return false;
    }

    public void update(int id,String old,String New){
        fileHandler.update(filename,"scheduleID="+id ,old,New);
    }

    public void delete(String id){
        fileHandler.deleteLineById(filename,"scheduleID="+id);
    }

    public String show_by_id(String id){
        if(search_by_id(id)){
            return fileHandler.readLineById(filename,"scheduleID="+id);
        }
        else{
            return "can not found thid id";
        }
    }

    @Override
    public String toString() {
        return super.toString()+" , department='" + department;
    }
}
