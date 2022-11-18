package Dao;

import BankException.ATMException;
import BankException.RegisterException;
import entity.Account;
import entity.VO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public abstract class AbstractDao {


    private  String registerIndex = "86";

    public  String getRegisterIndex() {
        return registerIndex;
    }

    public  void setRegisterIndex(String input){
        registerIndex = input;
    }

    public  void setRegisterIndexFromFile(){
        registerIndex = "";
    }

    public  Long supplyID( ) throws ATMException {
        LocalDate date = LocalDate.now();
        String dateNum = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if ( registerIndex == null || registerIndex.equals("") ||
                !registerIndex.substring(2, 10).equals(dateNum)) {
            registerIndex = "86"+dateNum + "0001";
        } else {
            if (registerIndex.substring(10).equals("9999")) {
                /*System.out.println("名额已经用完，请明天再来！");
                return -1L;*/
                throw new ATMException("注册名额已经用完，请明天再来！");
            } else {
                Long index = new Long(registerIndex) + 1L;
                registerIndex = String.valueOf(index);
            }
        }
        //后期将 registerIndex 写入文件保存
        
        return new Long(registerIndex);
    }
}
