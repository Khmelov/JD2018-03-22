package by.it.verishko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        ResourceManager rm = ResourceManager.INSTANCE;

        Scanner scanner = new Scanner(System.in);
        String line;
        String local = "";

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("ru")) {
                rm.setLocale(new Locale("ru", "RU"));
                local = "RU";
            }
            if (line.equals("be")) {
                rm.setLocale(new Locale("be", "BY"));
                local = "BY";
            }
            if (line.equals("en")) {
                rm.setLocale(Locale.US);
                local = "US";
            }
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(line, local));
            System.out.println(df.format(new Date()));
            System.out.println(rm.get(Messages.WELCOME));
            System.out.println(rm.get(Messages.NAME));
            System.out.println(rm.get(Messages.HOWDOYOUDO));
        }
    }
}