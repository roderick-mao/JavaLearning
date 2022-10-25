package javase.day04.lp1;

public interface CanFly {
    public void fly();
}

class Bird implements CanFly{
    public void fly(){
        System.out.println("bird flying");
    }
}
class Plane implements CanFly{
    public void fly(){
        System.out.println("plane flying");
    }
}

