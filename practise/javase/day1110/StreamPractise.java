package javase.day1110;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class StreamPractise {
    static String[] t1 = {"aaa","bb","ccc","dd"};
    static String[] t2 = {"eee","张fff","gg","张h"};
    static List<String> team1 = new ArrayList<>(Arrays.asList(t1));
    static List<String> team2 = new ArrayList<>(Arrays.asList(t2));

    public static void main(String[] args) {

        System.out.println("------------- 第一题 --------------");
        team1.stream().filter(s -> s.length()==3).forEach(System.out::println);
        System.out.println("------------- 第二题 --------------");
        team1.stream().limit(3).forEach(System.out::println);
        System.out.println("------------- 第三题 --------------");
        team2.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
        System.out.println("------------- 第四题 --------------");
        team2.stream().skip(2).forEach(System.out::println);
        System.out.println("------------- 第五题 --------------");
        Stream.concat(team1.stream(),team2.stream()).forEach(System.out::println);
        List<String> team3 = Stream.concat(team1.stream(),team2.stream()).collect(Collectors.toList());

    }

}
