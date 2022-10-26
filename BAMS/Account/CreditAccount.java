package Account;

public class CreditAccount extends Account{
    double ceiling;
    CreditAccount(){
        super();
        this.ceiling = 0;
    }
    CreditAccount(long id,String password,String name,String personId,String email, double ceiling){
        super(id,password,name,personId,email);
        this.ceiling = ceiling;
    }
}
