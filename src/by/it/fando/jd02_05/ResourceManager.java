package by.it.fando.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private final String path = "by.it.fando.jd02_05.ok.msg";

    public void setLocale (Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    private Locale locale = Locale.getDefault();
    private ResourceBundle resourceBundle;

    ResourceManager () {
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    String get (String key) {
        return resourceBundle.getString(key);
    }

}
