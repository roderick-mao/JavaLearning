package Dao;

import entity.Account;

public interface IDAO<E> {

    public boolean insert(Account e);

    public boolean delete(Long id);

    public boolean update(Account acct);

    public Account selectOne(Long id);
    public Account selectOne(Long id,String passwd);


    public E selectAll();
}

