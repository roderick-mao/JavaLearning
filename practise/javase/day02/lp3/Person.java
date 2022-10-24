package javase.day02.lp3;

public class Person {
    String name;
    int age;
    boolean gender;
    Person partner;
    public Person(String name, int age, boolean gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.partner = null;
    }

    public void marry(Person partner){
        if (this.gender == partner.gender){
            System.out.println("国内禁止结婚");
        }else {
            if (partner.isReady()&&this.isReady()){
                System.out.println("撒花");
                this.partner = partner;
                partner.partner = this;
            }
        }

    }

    public boolean isReady(){
        if((gender&&age<=24)||(!gender&&age<=22)){
            System.out.println("未达到年龄标准");
            return false;
        }else if (partner != null){
            System.out.println("滚");
            return false;
        } else {
            return true;
        }
    }
}
