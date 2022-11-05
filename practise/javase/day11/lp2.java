package javase.day11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class lp2 {
    public static void treeSetDemo(){
        String str = "8   10   15  5 2  7";
        String[] spl = str.split("\\s+");
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });
        treeSet.addAll(List.of(spl));
        System.out.println(treeSet);

    }

    public static void main(String[] args) {
        treeSetDemo();
    }
}
