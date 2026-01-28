package exceptions;

public class InvalidPasswordException extends RuntimeException {

    public static final String DEFAUL_MESSAGE = "Password too short. Will must be minimum 8 character long!";

    public InvalidPasswordException() {
        super(DEFAUL_MESSAGE);
    }
    public InvalidPasswordException(String message) {
        super(message);
    }
}
