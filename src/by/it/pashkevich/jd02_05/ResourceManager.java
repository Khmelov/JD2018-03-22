package by.it.pashkevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private final String path = "by.it.uskoryaev.jd02_05.ok.msg";

    private Locale locale = Locale.getDefault();
    private ResourceBundle resourceBundle;

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(path, locale);

    }

    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    String get(String key) {
        return resourceBundle.getString(key);
    }


}
