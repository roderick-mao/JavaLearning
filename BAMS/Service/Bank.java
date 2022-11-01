package Service;

import Dao.ArrayDao;
import entity.Account;
import entity.CreditAccount;
import entity.LoanAccount;
import entity.LoanCreditAccount;

public class Bank {

    ArrayDao ad =  ArrayDao.initArrayDao();

    public Account register(Long id, String password, String repassword,
                            String name, String personID, String email, int type){

        if (password.compareTo(repassword) != 0 ){
            throw new RuntimeException("两次密码输入有误");
        }
        switch (type){
            case 0:
                Account acct0 = new Account(id,password,name,personID,email);
                return acct0;
            case 1:
                Account acct1 = new CreditAccount(id,password,name,personID,email,5000);
                return acct1;
            case 2:
                LoanAccount acct2 = new LoanAccount();
                return acct2;
            case 3:
                LoanCreditAccount acct3 = new LoanCreditAccount();
                return acct3;
            default:
                throw new RuntimeException("账号类型错误，创建失败");
        }
    }

    public Account Login(long id,String passwd){
        return ad.selectOne(id,passwd);
    }

    public Account deposit (long id, double money){
        return ad.selectOne(id).deposit(money);
    }

    public Account withdraw(long id, double money){
        return ad.selectOne(id).withdraw(money);
    }

    public Account transfer(long from, String fromPasswd ,long to, double money){
        return null;
        //还没写完后面继续（标签）
    }
}
