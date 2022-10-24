package javase.day03.lp1;

class Employee {
    String name;
    int salary;

    public static void main(String[] args) {

    }
}

class EmployeeUtil{
    public static double bonus(Employee e){
        if (e.salary > 10000) {
            double bon = e.salary * 1.2;
            return bon;
        }else {
            double bon = e.salary * 1.1;
            return bon;
        }
    }
}

