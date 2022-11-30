package javase.day11;

import java.util.*;

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
        treeSet.addAll(Arrays.asList(spl));
        System.out.println(treeSet);

    }

    public static void main(String[] args) {
        treeSetDemo();
    }
}
