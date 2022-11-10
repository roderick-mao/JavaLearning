package Dao;

import BankException.ATMException;
import BankException.LoginException;
import BankException.RegisterException;
import entity.Account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ArrayDao extends AbstractDao implements IDAO{
    private Account[] accts;
    private int index;
    public ArrayDao(){
        Account[] accts = new Account[10];
        this.setRegisterIndex("");
        index = 0;
    }

    public  Account selectOne(Long id,String pwd) throws LoginException {
        for (int i = 0;i < index;i++){
            if (id == accts[i].getId() && accts[i].getPassword() == pwd){
                return accts[i];
            }
        }
        /*System.out.println("未找到匹配账号");
        return null;*/
        throw new LoginException("未找到匹配账号");
    }
    public Account selectOne(Long id) throws LoginException {
        for (int i = 0;i < index;i++){
            if (id == accts[i].getId()){
                return accts[i];
            }
        }
        /*System.out.println("未找到匹配账号");
        return null;*/
        throw new LoginException("未找到匹配账号");
    }

    @Override
    public boolean insert(Account acct) {
        if (index == accts.length - 1){
            accts = Arrays.copyOf(accts, accts.length+10);
        }
        accts[++index] = acct;
        return false;
    }
    @Override
    public Account[] selectAll(){
        return accts;
    }

    public boolean delete(Long id) throws ATMException {
        for (int i = 0;i < index;i++){
            if (id == accts[i].getId()){
                for (int y = i;y < index-1;y++){
                    accts[y] = accts[y+1];
                }
                index--;
                return true;
            }
        }
        /*System.out.println("未找到对应账号，删除失败！");
        return false;*/
        throw new ATMException("未找到匹配账号，删除失败！");
    }

    public boolean update(Account acc) throws ATMException {
        for (int i = 0;i < index;i++){
            if (acc.getId() == accts[i].getId()){
                accts[i] = acc;
                return true;
            }
        }
        /*System.out.println("未找到id相同的账号");
        return false;*/
        throw new ATMException("未找到匹配账号");
    }

}
