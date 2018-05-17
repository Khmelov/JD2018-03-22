package by.it.kovko.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Errors {
    NO_OPERATION, DIVISION_BY_ZERO, UNMATCHED_MATRICIES,
    UNMATCHED_VECTORS, FAIL_TO_SAVE, PROCESSING_ERROR, IMPOSSIBLE_OPERATION;
    private Errors(){};
    static private String resName = "by.it.kovko.calc.error_msg";
    static private ResourceBundle errorsRes
            = ResourceBundle.getBundle(resName, Locale.getDefault());
    static public void setLocale(Locale locale){
        errorsRes=ResourceBundle.getBundle(resName,locale);
    }

    @Override
    public String toString(){
        return errorsRes.getString(name());
    }

}
