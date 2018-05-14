package by.it.romankov.jd02_05;

import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        ResourceManager rm = ResourceManager.INSTANCE;
        if (args.length<2)
            rm.setLocale(Locale.US);
        else
            rm.setLocale(new Locale(args[0],args[1]));
        System.out.println(rm.get(by.it.akhmelev.jd02_05.Messages.WELCOME));
        System.out.println(rm.get(by.it.akhmelev.jd02_05.Messages.HOWDOYOUDO));
        System.out.println(rm.get(by.it.akhmelev.jd02_05.Messages.NAME));
    }
}
