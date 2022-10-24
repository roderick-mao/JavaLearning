package javase.day02.lp2;

public class TestGrandFather {
    public static void main(String[] args) {
        GrandFather grandFather = new GrandFather("test1",87);
        Father father = new Father("test2",45,"worker");
        grandFather.getGrandFather();
        father.getFather();
    }
}
