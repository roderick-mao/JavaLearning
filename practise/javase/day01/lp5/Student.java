package javase.day01.lp5;

import java.util.Map;

public class Student {
    public static final boolean Male = true;
    public static final boolean FeMale = false;

    private String name;
    private int age;
    private boolean gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getGender() {
        return gender;
    }

    public void learning(){
        System.out.println(age + "岁的"+this.whichGender()+"同学" + name + " 正在学习");
    }
    public String whichGender(){
        if(gender) {
            return "男";

        }else {
            return "女";
        }
    }
}
