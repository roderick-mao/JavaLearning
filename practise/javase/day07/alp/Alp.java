package javase.day07.alp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalTime;

class Alp {
    public static long runTime() throws InterruptedException {
        long start =  System.currentTimeMillis();

        for(int i=1;i<=10000;i++){
            System.out.print(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("");
        return end - start;

    }
    public static String hexToDec(String hex){
        BigInteger b = new BigInteger(hex,16);
        /*System.out.println(b.toString(10));*/
        return b.toString(10);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(runTime());
        System.out.println(hexToDec("2341ef542ef45d5326babc"));
    }


}
