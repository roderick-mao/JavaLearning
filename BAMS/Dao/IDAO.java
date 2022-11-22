package Dao;

import BankException.ATMException;
import BankException.LoginException;
import BankException.RegisterException;
import entity.Account;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.function.Supplier;

public interface IDAO<E> {

    public boolean insert(Account e) throws RegisterException, IOException;

    public boolean delete(Long id) throws ATMException, IOException;

    public boolean update(Account acct) throws ATMException, LoginException, IOException;

    public E selectOne(Long id) throws LoginException;

    public E selectOne(Long id,String passwd) throws  LoginException;

    public Collection<E> selectAll();

    public boolean hasPerson(String name,String personID) throws RegisterException;


}

