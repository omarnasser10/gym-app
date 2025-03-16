package com.mycompany.gymproject;
import java.util.ArrayList;
import java.util.List;
public class EquipmentManager extends Manager{
    private String filename="Equipments.txt";
    private final static String department="EquipmentManager";

    public EquipmentManager(){
        super();
    }

    public EquipmentManager(String name, String phone, String email, int age, double salary, String hiringDate) {
        super(name, phone, email, age, salary, hiringDate);
    }


    @Override
    public void add(Object item){
        if (item instanceof Equipment) {
            System.out.println("Equipment " + ((Equipment) item).getName() + " added successfully.");
            fileHandler.appendToFile(filename, String.valueOf(((Equipment) item))+"\n");
            Equipment.saveLastID("lastEquipmentID.txt");
        } else {
            System.out.println("Only Equipment can be added.");
        }
    }

    public boolean search_by_id(String id){
        if(fileHandler.searchContent(filename,"equipID="+id))
            return true;
        else return false;
    }

    public void update(int id,String old,String New){
        fileHandler.update(filename,"equipID="+id ,old,New);
    }

    public void delete(String id){
        fileHandler.deleteLineById(filename,"equipID="+id);
    }

    public String show_by_id(String id){
        if(search_by_id(id)){
            return fileHandler.readLineById(filename,"equipID="+id);
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
