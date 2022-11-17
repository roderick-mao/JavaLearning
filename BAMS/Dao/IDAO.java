package Dao;

import BankException.ATMException;
import BankException.LoginException;
import BankException.RegisterException;
import entity.Account;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public interface IDAO<E> {

    public boolean insert(Account e) throws RegisterException;

    public boolean delete(Long id) throws ATMException;

    public boolean update(Account acct) throws ATMException, LoginException;

    public E selectOne(Long id) throws LoginException;
    public E selectOne(Long id,String passwd) throws  LoginException;


    public Collection<E> selectAll();
}

