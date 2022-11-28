package javase.day1128.Hibernate;

import javase.day1128.Student;
import javase.day1128.Teacher;

public class HibernateDemo {

    public static void main(String[] args) {
        Student student = new Student("张三",101,18);
        Teacher teacher = new Teacher("王朝",10,"美术");
        print(student);
        print(teacher);
    }
    public static void print(Object o){

    }
}
