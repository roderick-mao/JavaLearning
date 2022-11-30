package javase.day1128.Hibernate;

import javase.day1128.Student;
import javase.day1128.Teacher;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class HibernateDemo {
    public static void main(String[] args) {
        Student student = new Student("里",101,18);
        Teacher teacher = new Teacher("赞",10,"音");
        print(student);
        print(teacher);
    }
    public static void print(Object o){

        //获取类类型
        Class<?> clazz = o.getClass();
        System.out.println("------------"+clazz.getSimpleName()+"----------------");

        //忽略其访问权限，获得所有属性
        Field[] fields = clazz.getDeclaredFields();
        Stream.of(fields).forEach(s->{
            s.setAccessible(true);
            try {
                System.out.println(s.getName()+" ： "+s.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
