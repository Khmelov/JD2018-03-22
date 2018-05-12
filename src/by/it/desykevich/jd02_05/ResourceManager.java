package by.it.desykevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private final String path="E:\\student\\Desukevich\\JD2018-03-22\\src\\by\\it\\desykevich\\jd02_05\\txt\\msg.properties";
    public void setLocale (Locale locale){
        this.locale=locale;
        resourceBundle= ResourceBundle.getBundle(path,locale);
    }
    private  Locale locale=Locale.getDefault();

    private ResourceBundle resourceBundle;

    ResourceManager(){
        resourceBundle=ResourceBundle.getBundle(path,locale);
    }

String get (String key){
return resourceBundle.getString(key);
}

}
