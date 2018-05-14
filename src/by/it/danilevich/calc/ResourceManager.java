package by.it.danilevich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private Locale locale = Locale.getDefault();


    public void setLocale(String nameBundle, Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(Util.getPathBundle(ResourceManager.class,nameBundle),locale);
    }
    public String get(String nameMsg){
        return resourceBundle.getString(nameMsg);

    }

}
