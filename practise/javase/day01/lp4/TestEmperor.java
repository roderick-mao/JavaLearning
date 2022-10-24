package javase.day01.lp4;

import java.time.LocalDate;
import java.time.Period;

public class TestEmperor {
    public static void main(String[] args) {
        Period st1 = Period.between(LocalDate.of(1908,1,1),
                LocalDate.of(1912,1,1));
        Period st2 = Period.between(LocalDate.of(1917,7,1),
                LocalDate.of(1917,7,12));
        Period reign = st1.plus(st2);
        Emperor puyi = new Emperor();
        puyi.setName("溥仪");
        puyi.setReign(reign);
        puyi.setRecord("丁巳复辟,伪满洲国“皇帝”");
        puyi.setDescription("字曜之，号浩然。清朝末代皇帝。是道光帝旻宁的曾孙、醇贤亲王奕譞之孙、光绪帝之侄，" +
                "摄政王载沣长子，母亲是苏完瓜尔佳·幼兰。1908年到1912年，1917年7月1日到1917年7月12日两次在位。");
        System.out.println(puyi);
    }
}
