package com.mycompany.gymproject;
public class Person{
    private String name;
    private String phone;
    private String email;
    private int age;

    public Person(){

    }
    public Person(String name, String phone, String email, int age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        ", age=" + age ;
    }
}
