package Dao;

import entity.Account;

import java.util.Arrays;

public class ArrayDao {
    private static Account[] accts;
    private static int index;
    private static ArrayDao arrayDao;
    private ArrayDao(){
        Account[] accts = new Account[10];
        index = 0;
    }
    public static ArrayDao initArrayDao(){
        if(arrayDao == null){
            arrayDao = new ArrayDao();
        }
        return arrayDao;
    }

    public  Account selectOne(Long id,String pwd){
        for (int i = 0;i < index;i++){
            if (id == accts[i].getId() && accts[i].getPassword() == pwd){
                return accts[i];
            }
        }
        System.out.println("未找到匹配账号");
        return null;
    }
    public Account selectOne(Long id){
        for (int i = 0;i < index;i++){
            if (id == accts[i].getId()){
                return accts[i];
            }
        }
        System.out.println("未找到匹配账号");
        return null;
    }

    public int insert(Account acct){
        if (index == (accts.length - 1)){
            accts = Arrays.copyOf(accts, accts.length+10);
        }
        accts[++index] = acct;
        return index;
    }

    public Account[] selectAll(){
        return accts;
    }

    public void delete(long id){
        for (int i = 0;i < index;i++){
            if (id == accts[i].getId()){
                for (int y = i;y < index-1;y++){
                    accts[y] = accts[y+1];
                }
                index--;
                break;
            }
        }
        System.out.println("未找到对应账号，删除失败！");
    }

    public void update(Account acc){
        for (int i = 0;i < index;i++){
            if (acc.getId() == accts[i].getId()){
                accts[i] = acc;
            }
        }
        System.out.println("未找到id相同的账号");
    }

}
