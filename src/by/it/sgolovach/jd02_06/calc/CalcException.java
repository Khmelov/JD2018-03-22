package by.it.sgolovach.jd02_06.calc;


public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(ConsoleRunner.rm.get(Messages.ERROR) + message);
     ConsoleRunner.director.errorReport();
//        ConsoleRunner.logger.toLog(ConsoleRunner.rm.get(Messages.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.rm.get(Messages.ERROR) + message, cause);
        ConsoleRunner.director.errorReport();
//        ConsoleRunner.logger.toLog(ConsoleRunner.rm.get(Messages.ERROR) + message + cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ConsoleRunner.rm.get(Messages.ERROR) + message, cause, enableSuppression, writableStackTrace);
        ConsoleRunner.director.errorReport();
//        ConsoleRunner.logger.toLog(ConsoleRunner.rm.get(Messages.ERROR) + message + cause + enableSuppression + writableStackTrace);
    }
}
