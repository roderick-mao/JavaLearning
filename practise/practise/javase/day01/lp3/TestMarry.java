package practise.javase.day01.lp3;

import com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi;
import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

import javax.xml.namespace.QName;

public class TestMarry {
    public static void main(String[] args) {
        Person t1 = new Person("甘雨",3000,false);
        Person t2 = new Person("钟离",5000,true);
        Person t3 = new Person("旅行者", 3000,true);
        Person t4 = new Person("马斯克",12,false);
        Person t5 = new Person("刻晴", 24,false);

        t4.marry(t1);
        t2.marry(t3);
        t3.marry(t4);
        t1.marry(t3);
        t5.marry(t3);
        t3.marry(t5);
    }
}
