package test;

import BankException.ATMException;
import BankException.LoginException;
import BankException.RegisterException;
import Dao.SetDao;
import Service.Bank;

public class Test {
    public static void main(String[] args) throws LoginException, ATMException, RegisterException {
        Bank bank = Bank.getInstance();
        System.out.println(bank.register("123","123","aaa","111","abc",0).getId());
        System.out.println(bank.register("123","123","aaa","111","abc",1).getId());
        System.out.println(bank.register("123","123","bbb","222","abc",2).getId());
        System.out.println(bank.register("123","123","ccc","333","abc",3).getId());
        bank.deposit(new Long("86202211150001"),5000).getProperty();
        bank.deposit(new Long("86202211150002"),3000).getProperty();
        bank.deposit(new Long("86202211150003"),5000).getProperty();
        bank.deposit(new Long("86202211150004"),5000).getProperty();

        bank.rankVO().forEach(System.out::println);

    }
}
