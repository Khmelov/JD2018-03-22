package by.it.poprugo.jd02_05.txt;

import by.it.poprugo.jd02_05.Messages;

import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        ResourceManager rm = ResourceManager.INSTANCE;

        if (args.length<2)
            rm.setLocale(Locale.US);
        else rm.setLocale(new Locale(args[0],args[1]));
        System.out.println(Messages.WELCOME);
        System.out.println(Messages.HOWDOYOUDO);
        System.out.println(Messages.NAME);


        /*rm.setLocale(Locale.US);
        System.out.println(Messages.WELCOME);
        System.out.println(Messages.HOWDOYOUDO);
        System.out.println(Messages.NAME);*/

        /*rm.setLocale(new Locale("be","BY"));
        System.out.println(Messages.WELCOME);
        System.out.println(Messages.HOWDOYOUDO);
        System.out.println(Messages.NAME);*/

    }
}
