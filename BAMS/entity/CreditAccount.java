package bams.BAMS.entity;


public class CreditAccount extends Account {
    private Account[] accs = new Account[3];

    private int index = 0;

    public boolean insert(Account acc){
        if(index>acc.length){
            accs = Arrays.copyOf(accs, accs.length*3/2+1);
        }
        return true;
    }
}
