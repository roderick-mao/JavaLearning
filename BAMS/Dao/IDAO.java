package Dao;

import BankException.ATMException;
import BankException.LoginException;
import entity.Account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface IDAO<E> {

    public boolean insert(Account e);

    public boolean delete(Long id) throws ATMException;

    public boolean update(Account acct) throws ATMException;

    public E selectOne(Long id) throws  LoginException;
    public E selectOne(Long id,String passwd) throws  LoginException;


    public E[] selectAll();


}

