package javase.day07;

import java.util.Objects;

public class EqualsDemo {



    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        System.out.println(a.equals(b));
        System.out.println(Objects.equals(a,a));
    }
}

class A{
    int test1 = 10;
}
