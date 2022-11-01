package javase.day09;

class Account {
    private String id;
    private String password;
    private double balance;
    public Account withdraw(double money) throws BalanceNotEnoughException {
        if (money > balance){
            throw new BalanceNotEnoughException("余额不足");
        }else {
            System.out.println("已取出"+money+"元");
            this.balance -= money;
            return this;
        }
    }

    public Account(String id, String password, double balance) {
        this.id = id;
        this.password = password;
        this.balance = balance;
    }


    public static void main(String[] args)  {
        Account acct = new Account("123","123",500);
        try {
            acct.withdraw(600);
        }catch (BalanceNotEnoughException e){
            e.printStackTrace();
        }

    }
}

class BalanceNotEnoughException extends Exception{
    public BalanceNotEnoughException() {
    }

    public BalanceNotEnoughException(String message) {
        super(message);
    }
}