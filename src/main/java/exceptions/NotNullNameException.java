package exceptions;

public class NotNullNameException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "You must enter the name!";

    public NotNullNameException() {
        super(DEFAULT_MESSAGE);
    }
    public NotNullNameException(String message) {
        super(message);
    }
}
