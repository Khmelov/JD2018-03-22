package by.it.desykevich.calc;

public class CalcException extends Exception{

 private Logger logger;

    public CalcException() {
    }

    public CalcException(String message) {

        super(message);
        logger=Logger.getLogger();
        logger.logWrite(message);
    }

    public CalcException(String message, Throwable cause) {

        super(message, cause);
        logger=Logger.getLogger();
        logger.logWrite(message + " " + cause.toString());
    }

    public CalcException(Throwable cause) {

        super(cause);
        logger=Logger.getLogger();
        logger.logWrite(cause.toString());
    }
}
