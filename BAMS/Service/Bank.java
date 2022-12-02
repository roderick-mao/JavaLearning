package Service;

import BankException.*;
import Dao.*;

import entity.*;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Bank {


    private IDAO<Account> ad ;

    private static Bank bank;

    private Bank() throws IOException, ClassNotFoundException {
        this.ad = new FileSetDao();
    }


    public static Bank getInstance() throws IOException, ClassNotFoundException {
        if (bank == null){
            bank = new Bank();
        }
        return bank;
    }

    public Account register(String password, String repassword,
                            String name, String personID, String email, AccountType type)
            throws ATMException, IOException {
        if (password != null && repassword!=null && name!=null && personID!=null && type!=null
        && !password.equals("") && !repassword.equals("") && !name.equals("") && !personID.equals("") && !type.equals("")) {

            if (password.compareTo(repassword) != 0) {
                throw new RegisterException("两次密码输入有误");
            }

            ad.hasPerson(name, personID);
            Long id = ((FileSetDao) ad).supplyID();

            switch (type) {
                case SAVING:
                    SavingAccount acct0 = new SavingAccount(id, password, name, personID, email, type);
                    System.out.println(id);
                    ad.insert(acct0);
                    return acct0;
                case CREDIT:
                    CreditAccount acct1 = new CreditAccount(id, password, name, personID, email, type);
                    System.out.println(id);
                    ad.insert(acct1);
                    return acct1;
                case LOANSAVING:
                    LoanSavingAccount acct2 = new LoanSavingAccount(id, password, name, personID, email, type);
                    System.out.println(id);
                    ad.insert(acct2);
                    return acct2;
                case LOANCREDIT:
                    LoanCreditAccount acct3 = new LoanCreditAccount(id, password, name, personID, email, type);
                    System.out.println(id);
                    ad.insert(acct3);
                    return acct3;
                default:
                    throw new RegisterException("账号类型错误，创建失败");
            }
        }else {
            throw new RegisterException("信息不能为空！");
        }
    }

    public Account Login(Long id,String passwd) throws LoginException {
        return ad.selectOne(id,passwd);
    }

    public Account deposit (Long id, double money) throws LoginException, ATMException, IOException {
        Account a = ad.selectOne(id);
        a.deposit(money);
        ad.update(a);
        return a;
    }

    public Account withdraw(Long id, String passwd,double money)
            throws BalanceNotEnoughException, LoginException, ATMException, IOException {
        Account a = ad.selectOne(id,passwd).withdraw(money);
        ad.update(a);
        return a;
    }

    public boolean transfer(Long from, String fromPasswd ,Long to, double money)
            throws BalanceNotEnoughException, TransferException, LoginException, ATMException, IOException {
        if (from != null && fromPasswd != null && !fromPasswd.equals("")){
            Account fromAccount = ad.selectOne(from,fromPasswd);
            Account toAccount = ad.selectOne(to);
            ad.update(fromAccount.withdraw(money));
            ad.update(toAccount.deposit(money));
            return true;
        }else {
            throw new LoginException("账号信息不能为空");
        }
    }

    public Account updateCeiling(Long id,String passwd,double money)
            throws TypeException, LoginException, ATMException, IOException {
        Account acct = ad.selectOne(id,passwd);
        if (acct instanceof CreditAccount){
            ((CreditAccount) acct).setCeiling(money);
            ad.update(acct);
            return acct;
        }else {
            throw new TypeException("该账号无法修改额度");
        }
    }

    public double sumAccount(){
        double sum = 0.0;
        for (Account account : ad.selectAll()) {
            if(account instanceof SavingAccount) {
                sum += account.getBalance();
            } else if (account instanceof CreditAccount) {
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
        double credits = 0.0;
        for (Account account : ad.selectAll()) {
            if (account instanceof CreditAccount) {
                if (account.getBalance()<0){
                    credits +=account.getBalance();
                }else {
                    continue;
                }
            }
        }
        return credits;
    }

    public Account requestLoan(Long id, double money) throws LoanException, LoginException, TypeException, ATMException, IOException {
        Account acct = null;
            acct = ad.selectOne(id);
            if (acct instanceof Loanable){
                Account a = ((Loanable) acct).requestLoan(money);
                ad.update(a);
                return  a;
            }else {
                //throw
                /*System.out.println("本账号无法办理贷款");
                return null;*/
                throw new TypeException("本账号无法办理贷款");
        }
    }

    public Account payLoan(Long id ,double money) throws LoginException, BalanceNotEnoughException, LoanException, TypeException, ATMException, IOException {
        Account acct = null;
        acct = ad.selectOne(id);
        if (acct instanceof Loanable){
            Account a = ((Loanable) acct).payLoan(money);
            ad.update(a);
            return  a;
        }else {
            throw new TypeException("本账号无贷款功能，无法还款");
        }
    }

    public double total(){
        double sum=0;
        for (Account acct : ad.selectAll()){
            if (acct instanceof Loanable){
                sum += ((Loanable) acct).getLoan();
            }
        }
        return sum;
    }

    public TreeSet<VO> rankVO(){
        Set<VO> vo = ((FileSetDao) ad).getAllVo();
        for (VO v: vo) {v.setProperty();}
        TreeSet<VO> treeVo = vo.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        return treeVo;
    }

}
