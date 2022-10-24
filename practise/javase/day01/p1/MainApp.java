package javase.day02.day01.p1;

import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
    Course course1 = new Course("s001","Java",LocalDate.of(2007,02,8),
            "Java学科，包含JavaSE和JavaEE");
    Course course2 = new Course("s002","IOS",LocalDate.of(2007,02,9),
            "IOS系统开发");

    Teacher teacher1 = new Teacher("t001","薛之谦", true, 26,course1);
    Teacher teacher2 = new Teacher("t002","张碧晨",false,24,course2);
    Teacher teacher3 = new Teacher("t003","张杰",true,28,course1);

    }
}

class Teacher{
    String teacherNum;
    String teacherName;
    boolean gender;
    int age;
    Course course;
    public Teacher(){
        this.teacherNum = "t000";
        this.teacherName = null;
        this.gender = false;
        this.age = 0;
    }
    public Teacher(String teacherNum, String teacherName, boolean gender, int age ,Course course){
        this.teacherNum = teacherNum;
        this.teacherName = teacherName;
        this.gender = gender;
        this.age = age;
        this.course = course;
    }

}

class Course{
    String courseNum;
    String courseName;
    LocalDate createTime;
    String description;
    public Course(){
        this.courseNum = "c000";
        this.courseName = null;
        this.createTime = LocalDate.of(2000,01,01);
        this.description = null;
    }
    public Course(String courseNum, String courseName, LocalDate createTime, String description){
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.createTime = createTime;
        this.description = description;
    }
}