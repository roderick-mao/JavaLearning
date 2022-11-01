package entity;

public class SavingAccount extends Account{

    SavingAccount(){
        super();
    }

    public SavingAccount(Long id,String password,String name,String personId,String email){
        super(id,password,name,personId,email);
    }
    @Override
    public Account withdraw(double amount) {
        if(amount <= this.getBalance()){
            this.setBalance(this.getBalance()-amount);
        }else{
            throw new RuntimeException("余额不足无法取出");
        }
        return this;
    }
}
