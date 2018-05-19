package by.it.danilevich.calc;

import java.io.IOException;

public class CallException extends Exception{

    public CallException() {
    }

    public CallException(String message) throws IOException {

        super("ERROR:" + message);
      }

    public CallException(String message, Throwable cause) throws IOException {
        super("ERROR:" + message, cause);
      }

    public CallException(Throwable cause) {
        super(cause);
    }

    public CallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) throws IOException {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
    }



}
