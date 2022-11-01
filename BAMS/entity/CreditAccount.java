package entity;


public class CreditAccount extends Account {
    double ceiling;
    CreditAccount(){
        super();
        this.ceiling = 0;
    }
    public CreditAccount(Long id, String password, String name, String personId, String email, double ceiling){
        super(id,password,name,personId,email);
        this.ceiling = ceiling;
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }


    @Override
    public Account withdraw(double amount) {
        if(amount <= this.getBalance()+this.ceiling){
            this.setBalance(this.getBalance()-amount);
        }else{
            throw new RuntimeException("余额不足无法取出");
        }
        return this;
    }

    public boolean reBalance(){
        if (this.getBalance() >= 0.0){
            return true;
        }else {
            System.out.println("请尽快还款");
            return false;
        }
    }
}

/*public class CreditAccount extends Account {
    private Account[] accs = new Account[3];

    private int index = 0;

    public CreditAccount(Long id, String password, String name, String personId, String email) {
        super(id, password, name, personId, email);
    }

    public boolean insert(Account acc){
        if(index>accs.length){
            accs = Arrays.copyOf(accs, accs.length*3/2+1);
        }
        return true;
    }
}*/
