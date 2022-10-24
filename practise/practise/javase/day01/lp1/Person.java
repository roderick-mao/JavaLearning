package practise.javase.day01.lp1;

public class Person {
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
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
