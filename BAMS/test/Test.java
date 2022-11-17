package test;

import BankException.*;
import Dao.SetDao;
import Service.Bank;
import entity.AccountType;

public class Test {
    public static void main(String[] args) throws LoginException, ATMException, RegisterException, BalanceNotEnoughException, TransferException {
        Bank bank = Bank.getInstance();
        System.out.println(bank.register("123","123","aaa","111","abc", AccountType.SAVING).getId());
        System.out.println(bank.register("123","123","aaa","111","abc",AccountType.CREDIT).getId());
        System.out.println(bank.register("123","123","bbb","222","abc",AccountType.LOANSAVING).getId());
        System.out.println(bank.register("123","123","ccc","333","abc",AccountType.LOANCREDIT).getId());
        bank.deposit(new Long("86202211170001"),5000).getProperty();
        bank.deposit(new Long("86202211170002"),3000).getProperty();
        bank.deposit(new Long("86202211170003"),5000).getProperty();
        bank.deposit(new Long("86202211170004"),5000).getProperty();
        bank.transfer(86202211170001L,"123",86202211170003L,5000);
        /*System.out.println( bank.Login(86202211170001L,"123").getBalance());
        System.out.println( bank.Login(86202211170003L,"123").getBalance());*/


        bank.rankVO().forEach(System.out::println);

    }
}
