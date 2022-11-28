package BankException;

public class LoanException extends ATMException{
    public LoanException() {
    }

    public LoanException(String message) {
        super(message);
    }
}
