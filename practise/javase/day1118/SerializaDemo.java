package javase.day1118;

import java.io.*;

public class SerializaDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person(1,"123");
        Person p2 = new Person(2,"234");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("123.txt"));
        oos.writeObject(p1);
        oos.writeObject(p2);
        /*ObjectInputStream ois = new ObjectInputStream(new FileInputStream("123.txt"));
        Person per1 = (Person) ois.readObject();
        Person per2 = (Person) ois.readObject();
        System.out.println(per1.toString());
        System.out.println(per2.toString());*/
    }

}

class Person implements Serializable{
    int num;
    String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名"+name+"序号"+num;
    }
}