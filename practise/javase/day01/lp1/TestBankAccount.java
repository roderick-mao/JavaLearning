package javase.day01.lp1;

import javase.day01.lp1.BankAccount;

public class TestBankAccount {
    public static void main(String[] args) {
    BankAccount acct = new BankAccount();
    acct.setAcctID(123);
    acct.setOwnerID(32431);
    acct.setOwnerName("mao");
    acct.setPhoneNo(123214214);
    acct.setEmail("fiejaofj");
    acct.getAcctID();
    acct.getEmail();
    acct.getOwnerID();
    acct.getOwnerName();
    acct.getPhoneNo();
    }
}
