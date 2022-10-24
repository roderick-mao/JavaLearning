package javase.day02.lp4;

public class TestEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee("t1","t1",10000);
        Director e2 = new Director("t2","t2",20000,500);
        Manager e3 = new Manager("t3","t3",15000,"t3");
        e1.show();
        e2.show();
        e3.show();
    }
}
