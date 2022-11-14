package entity;

import java.util.ArrayList;
import java.util.List;

public class VO implements Comparable<VO> {
    private final String name;
    private final String personID;
    private double property;

    private List<Account> bindCards = new ArrayList<>();

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
        return Double.compare(property,o.getProperty());
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
}
