package BankException;

public class TransferException extends ATMException{
    public TransferException() {
    }

    public TransferException(String message) {
        super(message);
    }
}
