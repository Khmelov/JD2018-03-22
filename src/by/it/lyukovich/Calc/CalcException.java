package by.it.lyukovich.Calc;

public class CalcException extends Exception {
    Logger logger = Logger.getLogger();
    public CalcException() {logger.log(this);}
    public CalcException(String message) {super("ERROR: "+message); logger.log(this);}
    public CalcException(String message, Throwable cause) {super("ERROR: "+message, cause); logger.log(this);}
    public CalcException(Throwable cause) {super("ERROR: "+ cause); logger.log(this);}
    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+message, cause, enableSuppression, writableStackTrace); logger.log(this);
    }
}
