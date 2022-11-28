package BankException;

public class RegisterException extends ATMException{
    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }
}
