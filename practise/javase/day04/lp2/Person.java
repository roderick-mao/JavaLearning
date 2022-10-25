package javase.day04.lp2;

import javase.day01.lp4.Emperor;

class Person {

    private String name;
    private String address;
    public Person (String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Employee extends Person implements Add{
    private String ID;
    private double wage;
    private int workAge;
    public Employee(String name, String address,String ID,double wage,int workAge){
        super(name, address);
        this.ID = ID;
        this.wage = wage;
        this.workAge = workAge;
    }
    public void addWage(){
        wage *= 1.1;
    }
    @Override
    public String toString() {
        return super.toString();
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

class Manager extends Employee {
    String level;

    public Manager(String name, String address, String ID, double wage, int workAge, String level) {
        super(name, address, ID, wage, workAge);
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addWage() {
        this.setWage(this.getWage() * 1.2);
    }
}

