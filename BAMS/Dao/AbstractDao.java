package Dao;

import BankException.ATMException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractDao {


    private static String registerIndex;

    public AbstractDao() {
        File f = new File("CardIds");
        if(f.exists() && f.length() > 0) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(f));
                registerIndex = br.lines().reduce((a, b) -> b).get();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            registerIndex = "";
        }
    }

    public  String getRegisterIndex() {
        return registerIndex;
    }

    public  void setRegisterIndex(String input){
        registerIndex = input;
    }

    public  void setRegisterIndexFromFile() throws IOException {
        File f = new File("CardIds");
        if(f.exists() && f.length()>0){
            BufferedReader br = new BufferedReader(new FileReader(f));
            registerIndex = br.lines().reduce((a,b)->b).get();
            br.close();
        }else {
            throw new FileNotFoundException("CardIds 文件不存在");
        }
    }

    public static Long supplyID( ) throws ATMException, IOException {
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
        File f = new File("CardIds");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
        bw.write(registerIndex);
        bw.newLine();
        bw.flush();
        bw.close();
        return new Long(registerIndex);
    }
}
