package javase.day02.day01.p2;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String bufNum = null;
        String bufName = null;
        String bufGender = null;
        double bufHeight = 0;
        int bufAge = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学员编号：");
        if  (scanner.hasNext()){
            bufNum = scanner.next();
        }
        System.out.println("请输入学员姓名：");
        if(scanner.hasNext()){
            bufName = scanner.next();
        }
        System.out.println("请输入学员性别：");
        if (scanner.hasNext()){
            bufGender = scanner.next();
        }
        System.out.println("请输入学员身高：");
        if(scanner.hasNextDouble()){
            bufHeight = scanner.nextDouble();
        }
        System.out.println("请输入学员年龄：");
        if(scanner.hasNextInt()){
            bufAge = scanner.nextInt();
        }
        scanner.close();
        Student student = new Student(bufNum,bufName,bufGender,bufHeight,bufAge);
        System.out.println(student);
    }
}



class Student {
    String studentNum;
    String studentName;
    String gender;
    double height;
    int age;

    public Student(String studentNum, String studentName, String gender, double height, int age) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.gender = gender;
        this.height = height;
        this.age = age;
    }

    @Override
    public String toString() {
        return "学生编号："+ this.studentNum+" 学生姓名："+this.studentName+" 性别："+this.gender+" 身高："+this.height+
                " 年龄："+this.age;
    }
}