package by.it.kovko.calc;

public class CalcException extends Exception {
    Logger logger = Logger.getLogger();
    Report report = ReportFactory.createReport();
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+ message);
        report.toReport(this);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+ message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+ message, cause, enableSuppression, writableStackTrace);
    }
}
