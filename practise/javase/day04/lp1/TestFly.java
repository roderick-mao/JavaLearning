package javase.day04.lp1;

public class TestFly {
    public static void makeFly(CanFly canFly){
        canFly.fly();
    }

    public static void main(String[] args) {
        CanFly f1 = new Bird();
        CanFly f2 = new Plane();
        makeFly(f1);
        makeFly(f2);
    }
}
