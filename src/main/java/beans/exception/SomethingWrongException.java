package beans.exception;

public class SomethingWrongException extends Exception {

    public SomethingWrongException(String errorMessage) {
        super(errorMessage);
    }
}
