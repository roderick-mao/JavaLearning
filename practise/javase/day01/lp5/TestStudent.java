package javase.day01.lp5;

import com.sun.javafx.sg.prism.NGExternalNode;

public class TestStudent {
    public static void main(String[] args) {
        Student test = new Student();
        test.setAge(12);
        test.setName("yangyang");
        test.setGender(test.Male);
        test.learning();
    }
}
