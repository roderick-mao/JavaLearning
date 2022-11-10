package Dao;

import entity.Account;

public class SetDao extends AbstractDao implements IDAO<Account>{

    @Override
    public boolean insert(Account e) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Account acct) {
        return false;
    }

    @Override
    public Account selectOne(Long id) {
        return null;
    }

    @Override
    public Account selectOne(Long id, String passwd) {
        return null;
    }

    @Override
    public Account[] selectAll() {
        return new Account[0];
    }
}
