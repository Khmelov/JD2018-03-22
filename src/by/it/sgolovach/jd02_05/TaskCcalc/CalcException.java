package by.it.sgolovach.jd02_05.TaskCcalc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(ConsoleRunner.rm.get(Messages.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.rm.get(Messages.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ConsoleRunner.rm.get(Messages.ERROR) + message, cause, enableSuppression, writableStackTrace);
    }
}
