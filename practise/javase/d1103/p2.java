package javase.d1103;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "姓名"+name+"薪资"+salary;
    }

    public static boolean addEmployee(ArrayList<Employee> al, Employee e){
        if (al.contains(e)) {
            return false;
        }else {
            al.add(e);
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class p2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Employee.addEmployee(arrayList,new Employee("abc",6000));
        Employee.addEmployee(arrayList,new Employee("abd",7000));
        Employee.addEmployee(arrayList,new Employee("abe",6000));
        Employee.addEmployee(arrayList,new Employee("abf",3000));
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    if (e1.getSalary()==e2.getSalary()){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return (int)(e2.getSalary() - e1.getSalary());
                    }
                }
                return 0;
            }
        });
        arrayList.forEach(System.out::println);
    }

}
