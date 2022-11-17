package Dao;

import BankException.*;
import entity.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDao extends AbstractDao implements IDAO<Account>{

    private Set<Account> accts;

    private Set<VO> vos;

    public SetDao(){
        accts = new HashSet<>();
        vos = new HashSet<>();
    }

    public Set<VO> getAllVo() {
        return vos;
    }

    public boolean hasPerson(String name,String personID) throws RegisterException {
        for (VO v : vos) {
            if (v.getPersonID().equals(personID)) {
                if (v.getName().equals(name)) {
                    return true;
                } else {
                    throw new RegisterException("用户身份证"+v.getPersonID()+"对应姓名已被注册为:" + v.getName());
                }
            }
        }
        return false;
    }

    @Override
    public boolean insert(Account e) throws RegisterException {
        if (e != null) {
            for (VO v : vos) {
                if (v.equals(e.getVo()) && v.getPersonID().equals(e.getVo().getPersonID())) {
                    if (v.getName().equals(e.getVo().getName())) {
                        e.setVo(v);
                        v.addCards(e);
                        accts.add(e);
                        return true;
                    } else {
                        throw new RegisterException("用户身份证"+v.getPersonID()+"对应姓名已被注册为:" + v.getName());
                    }
                }
            }
            e.getVo().addCards(e);
            vos.add(e.getVo());
            accts.add(e);

            return true;
        }
        throw new NullPointerException("账号不可为空");
    }

    @Override
    public boolean delete(Long id) {
        if (id != null) {
            Iterator<Account> iterator = accts.iterator();
            while (iterator.hasNext()) {
                Account e = iterator.next();
                if (e.getId().equals(id)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(Account acct) throws LoginException, ATMException {
        if (acct != null) {
            Iterator<Account> iterator = accts.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                Account e = iterator.next();
                if (e.getId().equals(acct.getId())) {
                    iterator.remove();
                    flag = true;
                }
            }

            if (flag == true) {
                accts.add(acct);
                return true;
            }else {
                throw new LoginException("未找到账户：" + acct.getId());
            }
        }
        throw new ATMException("账户不能为空");
    }

    @Override
    public Account selectOne(Long id) throws LoginException {
        for (Account e:
             accts) {
            if (e.getId().equals(id)){
                return e;
            }
        }
        throw new LoginException("未找到指定账号");
    }

    @Override
    public Account selectOne(Long id, String passwd) throws LoginException {
        if (id != null && passwd != null && !id.equals("") && !passwd.equals("")){
            for (Account e:
                 accts) {
                if (e.getId().equals(id) && e.getPassword().equals(passwd)){
                    return e;
                }
            }
            throw new LoginException("账号或密码错误");
        }
        throw new LoginException("账号或密码不可为空");
    }

    @Override
    public Set<Account> selectAll() {
        return accts;
    }
}
