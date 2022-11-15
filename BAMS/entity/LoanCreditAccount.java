package entity;

import BankException.BalanceNotEnoughException;
import BankException.LoanException;

public class LoanCreditAccount extends CreditAccount implements Loanable{

    private double loan;

    public LoanCreditAccount(Long id, String password, String name, String personId, String email, AccountType type) {
        super(id, password, name, personId, email,type);
        this.loan = 0.0;
    }

    @Override
    public double getLoan() {
        return loan;
    }

    void setLoan(double loan) {
        this.loan = loan;
    }

    @Override
    public Account requestLoan(double money) throws LoanException {
        if(money > 0 ){
            deposit(money);
            setLoan(money + loan);
            return this;
        }else {
            //throw
           /* System.out.println("贷款金额必须大于0！");
            return null;*/
            throw new LoanException("贷款金额应大于0");
        }
    }

    @Override
    public Account payLoan(double money) throws BalanceNotEnoughException, LoanException {
        if (money>0){
            if(money<=loan){
                if(money<=getBalance()){
                    withdraw(money);
                    setLoan(loan-money);
                    return this;
                }else {
                    //throw
                    /*System.out.println("额度不足");
                    return null;*/
                    throw new BalanceNotEnoughException("额度不足");
                }
            }else {
                //throw
                /*System.out.println("还款金额超限！");
                return null;*/
                throw new LoanException("还款金额超限！");
            }
        }else {
            //throw
            /*System.out.println("还款金额必须大于0!");
            return null;*/
            throw new LoanException("还款金额应大于0!");
        }
    }
}
