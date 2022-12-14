package entity;


import BankException.BalanceNotEnoughException;

public class CreditAccount extends Account {
    private double ceiling;
    CreditAccount(){
        super();
        this.ceiling = 0;
    }
    public CreditAccount(Long id, String password, String name, String personId, String email,AccountType type){
        super(id,password,name,personId,email,type);
        this.ceiling = 5000;
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }


    @Override
    public Account withdraw(double amount) throws BalanceNotEnoughException {
        if(amount <= super.getBalance()+this.ceiling){
            this.setBalance(super.getBalance()-amount);
        }else{
            throw new BalanceNotEnoughException("余额不足无法取出");
        }
        return this;
    }

    public boolean reBalance(){
        if (super.getBalance() >= 0.0){
            return true;
        }else {
            System.out.println("请尽快还款");
            return false;
        }
    }


    public double getRest() {
        return ceiling-this.getUsedCredit();
    }


    @Override
    public double getBalance(){
        if(super.getBalance()>0){
            return super.getBalance();
        }else {
            return 0;
        }
    }

    public double getUsedCredit(){
        if (super.getBalance()<0) {
            return -super.getBalance();
        }else {
            return 0;
        }
    }

    @Override
    public double getProperty() {
        return getBalance();
    }
}
