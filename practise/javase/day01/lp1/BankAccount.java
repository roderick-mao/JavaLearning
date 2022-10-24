package javase.day01.lp1;

public class BankAccount {
    private int acctID;
    private String ownerName;
    private int ownerID;
    private int phoneNo;
    private String email;

    public  BankAccount(){
        acctID = 12345;
    }
    public BankAccount(int acctID, String ownerName, int ownerID, int phoneNo, String email){
        this.acctID = acctID;
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public void setAcctID(int acctID){
        this.acctID = acctID;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public void setOwnerID(int ownerID){
        this.ownerID = ownerID;
    }

    public  void setPhoneNo(int phoneNo){
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getAcctID(){
        System.out.println("Account ID:"+this.acctID);
        return this.acctID;
    }

    public int getOwnerID(){
        System.out.println("Owner ID:"+this.ownerID);
        return this.ownerID;
    }

    public int getPhoneNo(){
        System.out.println("Phone No:"+this.phoneNo);
        return this.phoneNo;
    }

    public String getOwnerName(){
        System.out.println("Owner Name:"+this.ownerName);
        return this.ownerName;
    }

    public String getEmail(){
        System.out.println("Email:"+this.email);
        return this.email;
    }
}

class testacct extends BankAccount{
    String test;
    testacct(){
        super();
        this.test = "12345";

    }
}
