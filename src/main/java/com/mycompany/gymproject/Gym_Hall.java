package com.mycompany.gymproject;
import java.util.List;

public class Gym_Hall{
    private final int id=1001;
    private String name;
    private String location;
    private String openinghour;
    private List<Equipment> equipmentList;

    public Gym_Hall() {
    }

    public Gym_Hall(String name, String location, String openinghour) {
        this.name = name;
        this.location = location;
        this.openinghour = openinghour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpeninghour() {
        return openinghour;
    }

    public void setOpeninghour(String openinghour) {
        this.openinghour = openinghour;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(Equipment equipmentList) {
        this.equipmentList.add(equipmentList);
    }

    @Override
    public String toString() {
        return "name is : "+ this.name+", Location is :"+this.location+", openinghour is :"+this.openinghour
                +", Equipment{ "+this.getEquipmentList()+" }";
    }


}
