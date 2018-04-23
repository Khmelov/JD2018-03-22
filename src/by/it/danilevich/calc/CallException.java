package by.it.danilevich.calc;

public class CallException extends Exception{
    public CallException() {
    }

    public CallException(String message) {
        super("ERROR:" + message);
    }

    public CallException(String message, Throwable cause) {
        super("ERROR:" + message, cause);
    }

    public CallException(Throwable cause) {
        super(cause);
    }

    public CallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
    }
}
