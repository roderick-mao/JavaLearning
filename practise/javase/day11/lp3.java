package javase.day11;

import javase.day02.lp1.Person;

import java.util.HashSet;
import java.util.List;

class lp3 {
    public static void main(String[] args) {
        Person p1 = new Person("abc",15);
        Person p2 = new Person("abd",12);
        Person p3 = new Person("abe",19);
        Person p4 = new Person("abd",12);
        Person[] parr = {p1,p2,p3,p4};
        HashSet<Person> hashSet = new HashSet();
        for (Person p:
             parr) {
            hashSet.add(p);
        }
        System.out.println(hashSet);
    }

}

