package javase.day11;

import java.io.CharArrayWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class lp1 {

    public static void main(String[] args) {
        setDemo();
    }
    public static void setDemo() {
        HashSet<Character> set = new HashSet<>();
        String str = "aiodjl;hriWFUADJSV123UEHiowfjnivowe";
        char[] charArray = str.toCharArray();
        for (char c:charArray) {
            String regex = "[a-zA-z]";
            if (String.valueOf(c).matches(regex)){
                set.add(c);

            }
        }
        System.out.println(set);

    }
}
