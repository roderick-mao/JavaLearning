package entity;

import BankException.ATMException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VO implements Comparable<VO>, Serializable {
    private final String name;
    private final String personID;
    private double property;

    private List<Account> bindCards = new LinkedList<>();

    public boolean addCards(Account e){
        if (e!=null) {
            bindCards.add(e);
            return true;
        }
        throw new NullPointerException();
    }

    public VO(String name, String personID) {
        this.name = name;
        this.personID = personID;
    }

    @Override
    public int compareTo(VO o) {
        if (Double.compare(property,o.getProperty()) == 0){
            return getName().compareTo(o.getName());
        }else {
        return Double.compare(o.getProperty(),property);
        }
    }

    public void setProperty() {
        property = bindCards.stream().mapToDouble(Account::getProperty).sum();
    }

    public String getName() {
        return name;
    }

    public String getPersonID() {
        return personID;
    }

    public double getProperty() {
        return property;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VO) {
            return getPersonID().equals(((VO) obj).getPersonID());
        }
        return false;
    }

    @Override
    public String toString() {
        return "姓名："+name+" 身份证号："+personID+" 资产"+property;
    }

    public boolean removeCard(Account e) throws ATMException {
        if (e != null){
            Account del = null;
            for (Account a : bindCards){
                if (e.getId().equals(a.getId())){
                    del = a;
                }
            }
            if (del != null){
                bindCards.remove(del);
                return true;
            }else {
                throw new ATMException("未找到需要移除账户");
            }

        }
        throw new ATMException("需要删除的卡不可为空！");
    }
}
