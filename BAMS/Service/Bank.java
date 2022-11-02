package Service;

import Dao.ArrayDao;
import Dao.IDAO;
import entity.*;

public class Bank {

    IDAO ad =  ArrayDao.initArrayDao();

    public Account register(Long id, String password, String repassword,
                            String name, String personID, String email, int type){

        if (password.compareTo(repassword) != 0 ){
            throw new RuntimeException("两次密码输入有误");
        }
        switch (type){
            case 0:
                Account acct0 = new SavingAccount(id,password,name,personID,email);
                return acct0;
            case 1:
                Account acct1 = new CreditAccount(id,password,name,personID,email,5000);
                return acct1;
            case 2:
                LoanSavingAccount acct2 = new LoanSavingAccount();
                return acct2;
            case 3:
                LoanCreditAccount acct3 = new LoanCreditAccount();
                return acct3;
            default:
                throw new RuntimeException("账号类型错误，创建失败");
        }
    }

    public Account Login(Long id,String passwd){
        return ad.selectOne(id,passwd);
    }

    public Account deposit (Long id, double money){
        return ad.selectOne(id).deposit(money);
    }

    public Account withdraw(Long id, String passwd,double money){
        return ad.selectOne(id,passwd).withdraw(money);
    }

    public boolean transfer(Long from, String fromPasswd ,Long to, double money){
        if (from!=null && fromPasswd!=null && !from.equals("") && !fromPasswd.equals("")){
            Account fromAccount = ad.selectOne(from,fromPasswd);
            Account toAccount = ad.selectOne(from);
            if(fromAccount!=null){
                if(toAccount!=null){
                    try {
                        fromAccount.withdraw(money);
                    }catch (RuntimeException e){
                        e.toString();
                    }
                    toAccount.deposit(money);
                    return true;
                }else {
                    throw new RuntimeException("收款账号不存在");
                }
            }else {
                throw new RuntimeException("汇款账号不存在");
            }

        }else {
            throw new RuntimeException("账号信息不能为空");
        }
    }

    public Account updateCeiling(Long id,String passwd,double money){
        Account acct = ad.selectOne(id,passwd);
        if (acct != null && acct instanceof CreditAccount){
            ((CreditAccount) acct).setCeiling(money);
            return acct;
        }else {
            throw new RuntimeException("该账号无法修改额度");
        }
    }

    public double sumAccount(){
        double sum = 0;
        for (Account account : (Account[]) ad.selectAll()) {
            if(account instanceof SavingAccount || account instanceof LoanSavingAccount) {
                sum += account.getBalance();
            } else if (account instanceof CreditAccount ||account instanceof LoanCreditAccount) {
                if (account.getBalance()<0){
                    continue;
                }else {
                    sum +=account.getBalance();
                }
            }
        }
        return sum;
    }

    public double sumCredit(){
        return 0;
    }
}
