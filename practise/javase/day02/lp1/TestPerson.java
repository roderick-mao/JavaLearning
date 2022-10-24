package javase.day02.lp1;

public class TestPerson {
    public static void main(String[] args) {
        Student stu = new Student("张三",22);
        Worker worker = new Worker("李四",25);
        stu.learning();
        worker.working();
    }
}
