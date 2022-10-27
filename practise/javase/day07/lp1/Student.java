package javase.day07.lp1;

import com.sun.deploy.util.SyncAccess;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

class Student {
    String name;
    int num;

    public Student(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return num == student.num &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    @Override
    public String toString() {
        return "姓名："+name+"  学号："+num;
    }
}

class StudentDemo{
    static Student[] stuArray;
    static int index=0;

    static void addStu(Student stu){
        if (index == stuArray.length){
            stuArray = Arrays.copyOf(stuArray,(stuArray.length)/3*2+1);
        }
        int i;
        for (i=0 ;i<index;i++){
            if (stuArray[i].equals(stu)){
                System.out.println("学生信息相同，无法录入");
                break;
            }
        }
        if (i == index){
            stuArray[index++] = stu;
        }

    }


    public static void main(String[] args) {
        stuArray = new  Student[10];
        Student stu1 = new Student("1",1);
        Student stu2 = new Student("2",2);
        Student stu3 = new Student("3",3);
        Student stu4 = new Student("2",2);

        addStu(stu1);
        addStu(stu2);
        addStu(stu3);
        addStu(stu3);
        for (int i = 0;i<index;i++) {
            System.out.println(stuArray[i]);
        }
    }
}
