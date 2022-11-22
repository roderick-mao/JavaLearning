package entity;

import BankException.BalanceNotEnoughException;

import java.io.Serializable;

public abstract class Account implements Serializable {

    private final Long id;
    private String password;
    private VO vo;
    private String email;
    private double balance;

    AccountType type;

    public AccountType getType() {
        return type;
    }

    Account(){
        id = 10000L;
        password = "123456";
        vo = null;
        email = "default@test.com";
        balance = 0;
        type = AccountType.SAVING;
    }

    public Account(Long id,String password,String name,String personId,String email,AccountType type){
        this.id = id;
        this.password = password;
        vo = new VO(name,personId);
        this.email = email;
        this.balance = 0;
        this.type = type;
    }

    public abstract double getProperty();

    public final Account deposit(double amount){
        balance += amount;
        return this;
    }

    public abstract Account withdraw(double amount) throws BalanceNotEnoughException;
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public VO getVo() {
        return vo;
    }

    public void setVo(VO vo) {
        this.vo = vo;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }
}
