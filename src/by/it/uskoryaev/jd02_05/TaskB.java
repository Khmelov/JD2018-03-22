package by.it.uskoryaev.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskB {
    public static void main(String[] args) {
        ResourceManager rm = ResourceManager.INSTANCE;
        Date date = new Date();


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            switch (s) {
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    System.out.println(rm.get(Messages.WELCOME));
                    System.out.println(rm.get(Messages.HOWDOYOUDO));
                    System.out.println(rm.get(Messages.NAME));
                    DateFormat dateFormatRU = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU"));
                    String forRU = dateFormatRU.format(date);
                    System.out.println(forRU);
                    break;
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    System.out.println(rm.get(Messages.WELCOME));
                    System.out.println(rm.get(Messages.HOWDOYOUDO));
                    System.out.println(rm.get(Messages.NAME));
                    DateFormat dateFormatBY = DateFormat.getDateInstance(DateFormat.LONG, new Locale("be", "BY"));
                    String forBY = dateFormatBY.format(date);
                    System.out.println(forBY);
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "EN"));
                    System.out.println(rm.get(Messages.WELCOME));
                    System.out.println(rm.get(Messages.HOWDOYOUDO));
                    System.out.println(rm.get(Messages.NAME));
                    DateFormat dateFormatEN = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "EN"));
                    String forEN = dateFormatEN.format(date);
                    System.out.println(forEN);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
