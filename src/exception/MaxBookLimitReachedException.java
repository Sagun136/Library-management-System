package exception;

public class MaxBookLimitReachedException extends Exception {

    public MaxBookLimitReachedException(String message) {
        super(message);
    }
}
