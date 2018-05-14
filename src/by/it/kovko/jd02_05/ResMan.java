package by.it.kovko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {
    INSTANCE;
    private ResourceBundle res;
    //private final String resName = "by.it.kovko.jd02_05.msg";
    private final String resName = "by.it.kovko.jd02_05.fromtxt.Message";
    private ResMan(){
        res = ResourceBundle.getBundle(resName, Locale.getDefault());
    }

    public void changeRes(Locale locale) {
        res = ResourceBundle.getBundle(resName, locale);
    }
    public String getString(String key){
        return res.getString(key);
    }
}
