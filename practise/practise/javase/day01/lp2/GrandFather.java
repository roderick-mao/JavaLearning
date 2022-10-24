package practise.javase.day01.lp2;

import javase.day01.lp6.Grade;

public class GrandFather {
    String name;
    int age;
    public String getGrandFather(){
        System.out.println("爷爷叫"+name+","+age+"岁");
        return "爷爷叫"+name+","+age+"岁";
    }
    public GrandFather(String name, int age){
        this.name = name;
        this.age = age;
    }

}

class Father extends GrandFather{
    String occupation;

    public Father(String name, int age,String occupation) {
        super(name, age);
        this.occupation = occupation;
    }

    public String getFather(){
        System.out.println("爸爸叫"+name+","+age+"岁,职业是"+occupation);
        return "爸爸叫"+name+","+age+"岁,职业是"+occupation;
    }

}
