package BankException;

public class LoanException extends Exception{
    public LoanException() {
    }

    public LoanException(String message) {
        super(message);
    }
}
