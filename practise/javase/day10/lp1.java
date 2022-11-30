package javase.day10;

import java.util.*;

public class lp1 {
    public static void main(String[] args) {
        String str = "9 10 12 6 8 15";
        ArrayList<String> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(str.split("\\s+")));
        nums.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                Integer n1 = Integer.parseInt(o1);
                Integer n2 = Integer.parseInt(o2);
                return n1.compareTo(n2);
            }
        });
        /*Iterator<String> it = nums.iterator();*/
        nums.forEach(o->System.out.print(o+" "));


    }
}
