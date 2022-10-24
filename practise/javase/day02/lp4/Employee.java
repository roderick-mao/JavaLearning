package javase.day02.lp4;

import javase.day01.lp4.Emperor;

import java.util.Map;

class Employee {
    String name;
    String location;
    float salary;
    public Employee(String name, String location, float salary){
        this.name = name;
        this.location = location;
        this.salary = salary;
    }
    public void show(){
        System.out.println("姓名："+this.name+" 住址："+this.location+" 薪资："+this.salary);
    }

}
class Director extends Employee{
    float transportationSubsidy;
    public Director(String name, String location, float salary, float transportationSubsidy){
        super(name,location,salary);
        this.transportationSubsidy = transportationSubsidy;
    }
    @Override
    public void show(){
        super.show();
        System.out.println("交通补助："+this.transportationSubsidy);
    }
}

class Manager extends Employee{
    String department;
    public Manager(String name, String location, float salary,String department){
        super(name,location,salary);
        this.department = department;
    }
    @Override
    public void show(){
        super.show();
        System.out.println("管理部门："+this.department);
    }

}
