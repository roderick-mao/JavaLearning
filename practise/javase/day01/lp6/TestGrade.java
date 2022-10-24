package javase.day01.lp6;

public class TestGrade {
    public static void main(String[] args) {
        Grade test1 = new Grade(110,23,46);
        Grade test2 = new Grade();
        test2.setCshapeGrade(123);
        test2.setDbGrade(132);
        test2.setJavaGrade(125);
        System.out.println(test1.average());
        System.out.println(test2.average());
        System.out.println(test1.sum());
        System.out.println(test2.sum());

    }
}
