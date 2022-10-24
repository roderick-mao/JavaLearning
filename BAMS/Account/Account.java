package Account;

import sun.management.counter.AbstractCounter;

public class Account {
    private final long id;
    private String password;
    private String name;
    private final String personId;
    private String email;
    private double balance;

    public Account(long id,String password,String name,String personId,String email){
        this.id = id;
        this.password = password;
        this.name = name;
        this.personId = personId;
        this.email = email;
        this.balance = 0;
    }

    private Account deposit(double amount){
        balance += amount;
        return this;
    }

    private Account withdraw(double amount){
        if (amount > balance){
            System.out.println("无法取出，得加钱！");
            return this;
        }else {
            balance -= amount;
            return this;
        }
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPersonId() {
        return personId;
    }


}
