
package com.mycompany.gymproject;
public class Employee extends Person {
    private double salary;
    private String hiringDate;

    public Employee(){
        super();

    }
    public Employee(String name, String phone, String email, int age, double salary, String hiringDate) {
        super(name, phone, email, age);
        this.salary = salary;
        this.hiringDate = hiringDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", salary=" + salary +
                ", hiringDate='" + hiringDate + '\'';
    }
}
