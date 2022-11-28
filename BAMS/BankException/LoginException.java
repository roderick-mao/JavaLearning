package BankException;

public class LoginException extends ATMException{
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
