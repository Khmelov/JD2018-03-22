package by.it.kirova.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) throws IOException {

        System.out.println("Task A:\n");
        ResourceManager rm = ResourceManager.INSTANCE;
        if (args.length<2)
            rm.setLocale(Locale.US);
        else
            rm.setLocale(new Locale(args[0],args[1]));
        System.out.println(rm.get(Messages.WELCOME));
        System.out.println(rm.get(Messages.HOWDOYOUDO));
        System.out.println(rm.get(Messages.NAME));


        System.out.println("\nTask B:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Date d = new Date();
        String lang = "";
        while (!lang.equals("end")) {

            System.out.println("\nВыберите язык вывода данных или \"end\":");
            lang = reader.readLine();
            switch (lang) {
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "US"));
                    break;
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    break;
                default:
                    return;
            }
            DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag(lang));
            System.out.println(rm.get(Messages.WELCOME));
            System.out.println(rm.get(Messages.HOWDOYOUDO));
            System.out.println(rm.get(Messages.NAME));
            System.out.println(dt.format(d));

        }

    }
}
