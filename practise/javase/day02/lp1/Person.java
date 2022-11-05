package javase.day02.lp1;

import java.util.Objects;

public class Person {
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
            Person anotherPerson = (Person)obj;
            if (this.name == anotherPerson.name && this.age == anotherPerson.age){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"年龄："+this.age;
    }
}

class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }

    public void learning(){
        System.out.println("有个学生叫"+this.name+","+this.age+"岁，正在学习");
    }

}

class Worker extends Person{
    public Worker(String name, int age) {
        super(name, age);
    }

    public void working(){
        System.out.println("有个工人叫"+this.name+","+this.age+"岁，正在工作");
    }
}
