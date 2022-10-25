package javase.day04.lp2;

public class TestAdd {

    public static void main(String[] args) {


        Add e1 = new Employee("e1", "e1", "e1", 5000, 3);
        Add e2 = new Manager("e2", "e2", "e2", 5000, 5, "3");
        e1.addWage();
        e2.addWage();
    }
}
