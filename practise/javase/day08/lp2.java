package javase.day08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class lp2 {
    public static void findRegex(){
        String string = "你好，若有问题请及时电话联系0510-1231231或者05101112223，也可以发送邮件至123@qq.com。" +
                "若遇紧急问题，可拨打13911112222，或者18523234646。欢迎致电800-820-8820，8008208820。" +
                "从以上文字中，通过正则匹配，爬取所有联系方式。";
        String phone = "(1[3-9]\\d{9})|(0\\d{3}-?\\d{7})|(800-?\\d{3}-?\\d{4})|(\\w{3,}@\\w{2,}(\\.[a-z]{2,}))";
        Pattern pattern = Pattern.compile(phone);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }

    public static void main(String[] args) {
        findRegex();
    }
}
