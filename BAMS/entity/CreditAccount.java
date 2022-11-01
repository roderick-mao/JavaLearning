package entity;


public class CreditAccount extends Account {
    double ceiling;
    CreditAccount(){
        super();
        this.ceiling = 0;
    }
    public CreditAccount(long id, String password, String name, String personId, String email, double ceiling){
        super(id,password,name,personId,email);
        this.ceiling = ceiling;
    }
}

/*public class CreditAccount extends Account {
    private Account[] accs = new Account[3];

    private int index = 0;

    public CreditAccount(long id, String password, String name, String personId, String email) {
        super(id, password, name, personId, email);
    }

    public boolean insert(Account acc){
        if(index>accs.length){
            accs = Arrays.copyOf(accs, accs.length*3/2+1);
        }
        return true;
    }
}*/
