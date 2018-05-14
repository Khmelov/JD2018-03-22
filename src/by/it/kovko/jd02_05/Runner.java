package by.it.kovko.jd02_05;

//import sun.util.locale.LocaleExtensions;

//import java.util.Enumeration;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
//import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.INSTANCE;
        HashMap<String, Locale> localeMap = new HashMap<>();
        localeMap.put("ru", new Locale("ru", "RU"));
        localeMap.put("en", new Locale("en", "US"));
        localeMap.put("be", new Locale("be", "BY"));
        String locale="en";
        Scanner scanner = new Scanner(System.in);
        DateFormat df=null;
        Locale currentLocale=null;

        do {
            if ((currentLocale=localeMap.get(locale))!=null) {
                rm.changeRes(currentLocale);
                df = DateFormat.getDateInstance(DateFormat.FULL, currentLocale);
                System.out.println(ResMan.INSTANCE.getString("msg.welcome"));
                System.out.println(ResMan.INSTANCE.getString("msg.name"));
                System.out.println(ResMan.INSTANCE.getString("msg.question"));
                System.out.println(df.format(new Date()));
            }

        } while (!(locale=scanner.nextLine()).equals("end"));
    }
}
