package javase.day06;

import com.sun.deploy.util.SyncAccess;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

class AfterClass {
    /**
     * 计算出生日日期至今的天数
     * @return 天数
     */
    public static int daysBetwBirth() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse("1996-11-18");
        Date today = new Date();
        return Math.abs(birthday.compareTo(today));
    }

    /**
     * 计算出三天后的时间日期
     * @return Date 日期类
     */
    public static Date after3day(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        long d3 = 3600*24*3;
        long td = System.currentTimeMillis();
        Date a3d = new Date(d3+td);
        return a3d;
    }

    public static Calendar overDue(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2022);
        c.set(Calendar.MONTH,4);
        c.set(Calendar.DAY_OF_MONTH,10);
        c.add(Calendar.DAY_OF_YEAR,180);
        return c;
    }

    public static String lastMonth(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH,-1);
        c.set(Calendar.DAY_OF_MONTH,3);
        String[] weekDay = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return weekDay[c.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static LocalDate nextMonth(){
        LocalDate ld = LocalDate.now();
        ld = ld.plusMonths(1);
        ld =  ld.withDayOfMonth(ld.lengthOfMonth()-2);
        return ld;
    }

    public static News[] sortNews(){
        //initiate a news array
        News[] news = new News[10];
        for (int i = 0 ;i<10;i++){
            news[i] = new News("title"+i,"content"+i,LocalDateTime.of
                    (2022,(int)(Math.random()*12+1),(int)(Math.random()*30+1),(int)(Math.random()*23+1),
                            (int)(Math.random()*59+1),(int)(Math.random()*59+1)));
        }
        //排序
        for (int i = 0;i<10;i++){
            for (int j = (i+1);j<10;j++){
                if (news[i].getTime().isBefore(news[j].getTime())){
                    News temp = news[i];
                    news[i] = news[j];
                    news[j] = temp;
                }
            }
        }

        return news;
    }
    public static Student[] earlierZhang(){
        Student zhang = new Student("张三",1000,LocalDate.of(1999,6,1));
        //initiate a news array
        Student[] stus = new Student[10];
        for (int i = 0 ;i<10;i++){
            stus[i] = new Student("name"+i,i,LocalDate.of
                    (1999,(int)(Math.random()*12+1),(int)(Math.random()*30+1)));
        }
        Student[] bigger = new Student[10];
        int index = 0;
        //排序
        for (int i = 0;i<10;i++){
            if (stus[i].getBirthday().isBefore(zhang.getBirthday())){
                bigger[index++] = stus[i];
            }

        }

        return bigger;
    }



}
class News{

    private String title;
    private String content;
    private LocalDateTime time;

    public News(String title, String content, LocalDateTime time) {
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "title:"+title+"  content:"+content+"   time:"+time.toString();
    }
}

class Student{
    private String name;
    private int num;
    private LocalDate birthday;

    public Student(String name, int num, LocalDate birthday) {
        this.name = name;
        this.num = num;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "name:"+name+"  num:"+num+"   time:"+birthday.toString();
    }
}


class AfterClassDemo{
    public static void main(String[] args) throws ParseException {
        System.out.println("从出生到现在"+AfterClass.daysBetwBirth()+"天");
        System.out.println("三天后的日期为："+AfterClass.after3day());
        System.out.println("过期日期为："+AfterClass.overDue().get(Calendar.YEAR)+
        "年"+(AfterClass.overDue().get(Calendar.MONTH)+1)+"月"+AfterClass.overDue().get(Calendar.DATE)+"日");
        System.out.println("上个月的第三天是星期几："+AfterClass.lastMonth());
        System.out.println("下个月倒数第三天："+AfterClass.nextMonth());
        System.out.println(Arrays.toString(AfterClass.sortNews()));
        System.out.println(Arrays.toString(AfterClass.earlierZhang()));
    }

}
