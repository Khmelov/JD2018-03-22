package by.it.poprugo.jd02_05.txt;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private final String path = "by.it";

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    private Locale locale = Locale.getDefault();
    private ResourceBundle resourceBundle;

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    //String get (String key);
}
