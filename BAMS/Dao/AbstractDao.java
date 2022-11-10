package Dao;

import BankException.ATMException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractDao {

    private String registerIndex;



    public String getRegisterIndex() {
        return this.registerIndex;
    }

    public  void setRegisterIndex(String registerIndex){
        this.registerIndex = registerIndex;
    }

    public void setRegisterIndexFromOutside(){
        this.registerIndex = "000000000000";
    }

    public Long supplyID( ) throws ATMException {
        LocalDate date = LocalDate.now();
        String dateNum = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        if ( this.registerIndex == null || this.registerIndex.equals("") ||
                !this.registerIndex.substring(0, 7).equals(dateNum)) {
            Long index = Long.getLong((dateNum + "0001"));
            this.registerIndex = String.valueOf(index);
        } else {
            if (this.registerIndex.substring(8).equals("9999")) {
                /*System.out.println("名额已经用完，请明天再来！");
                return -1L;*/
                throw new ATMException("注册名额已经用完，请明天再来！");
            } else {
                Long index = Long.getLong(this.registerIndex) + 1;
                this.registerIndex = String.valueOf(index);
            }
        }
        String str = "86215021" + this.registerIndex;
        //后期将 registerIndex 写入文件保存
        return Long.getLong(str);
    }
}
