package javase.day01.lp3;

public class TestCar {
    public static void main(String[] args) {
        Car car = new  Car();
        car.setBrand("Tesla");
        car.setColor("black");
        car.setLic("b231");
        car.setNew(true);
        System.out.println(car);
    }
}
