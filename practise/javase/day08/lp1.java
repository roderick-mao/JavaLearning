package javase.day08;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

class lp1 {
    public static String[] sortStrings(int mod) {
        String[] as = {"nba", "abc", "cba", "zz", "qq", "haha"};
        if(mod == 0) {
            for (int i = 0; i < as.length; i++) {
                for (int j = i + 1; j < as.length; j++) {
                    if (as[i].compareTo(as[j]) < 0) {
                        String temp = as[j];
                        as[j] = as[i];
                        as[i] = temp;
                    }
                }
            }
            return as;
        }else if(mod == 1){
            Arrays.sort(as, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });
            return as;
        }else {
            return as;
        }
    }

    public static String reverse(String string){
        StringBuilder s = new StringBuilder(string);
        return s.reverse().toString();
    }

    public static String arrToString(int[] arr){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0;i<arr.length;i++){
            s.append(arr[i]+",");
        }
        s.delete(s.length()-1,s.length());
        s.append("]");
        return s.toString();
    }

    public static boolean isSymmetry(String string){
        StringBuffer s = new StringBuffer(string);
        for (int i = 0 ;i<=((int)(string.length()-1)/2);i++){
            if(s.charAt(i) != s.charAt(string.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println( Arrays.toString( lp1.sortStrings(1)));
        int[] arr = {1,2,3,4,5};
        System.out.println(lp1.arrToString(arr));
        System.out.println(isSymmetry("abcbaba"));
    }
}
