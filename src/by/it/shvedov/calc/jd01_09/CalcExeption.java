package by.it.shvedov.calc.jd01_09;

public class CalcExeption extends  Exception {
    public CalcExeption() {
    }

    public CalcExeption(String message) {
        super("ERROR: "+message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcExeption(Throwable cause) {
        super("ERROR: "+cause);
    }

    public CalcExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+message, cause, enableSuppression, writableStackTrace);
    }
}
