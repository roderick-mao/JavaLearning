package entity;

import BankException.BalanceNotEnoughException;
import BankException.LoanException;

public interface Loanable {

    public Account requestLoan( double money) throws LoanException;

    public Account payLoan(double money) throws BalanceNotEnoughException, LoanException;

    public double getLoan();
}
