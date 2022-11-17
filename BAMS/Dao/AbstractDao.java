package Dao;

import BankException.ATMException;
import BankException.RegisterException;
import entity.Account;
import entity.VO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public abstract class AbstractDao {


    private static String registerIndex = "";

    public static String getRegisterIndex() {
        return registerIndex;
    }

    public static void setRegisterIndex(String input){
        registerIndex = input;
    }

    public static void setRegisterIndexFromOutside(){
        registerIndex = "";
    }

    public static Long supplyID( ) throws ATMException {
        LocalDate date = LocalDate.now();
        String dateNum = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if ( registerIndex == null || registerIndex.equals("") ||
                !registerIndex.substring(0, 8).equals(dateNum)) {
            Long index = new Long(dateNum + "0001");
            registerIndex = String.valueOf(index);
        } else {
            if (registerIndex.substring(8).equals("9999")) {
                /*System.out.println("名额已经用完，请明天再来！");
                return -1L;*/
                throw new ATMException("注册名额已经用完，请明天再来！");
            } else {
                Long index = new Long(registerIndex) + 1;
                registerIndex = String.valueOf(index);
            }
        }
        String str = "86" + registerIndex;
        //后期将 registerIndex 写入文件保存
        return new Long(str);
    }
}
