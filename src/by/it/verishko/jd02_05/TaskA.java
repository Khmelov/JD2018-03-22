package by.it.verishko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {
    public static void main(String[] args) {
        ResourceManager rm = ResourceManager.INSTANCE;
        if (args.length < 2)
            rm.setLocale(Locale.US);
        else
            rm.setLocale(new Locale(args[0], args[1]));
//        rm.setLocale(new Locale(be, BY));
        System.out.println(rm.get(Messages.WELCOME));
        System.out.println(rm.get(Messages.HOWDOYOUDO));
        System.out.println(rm.get(Messages.NAME));
    }


//    public static void main(String[] args) {
//        for (Integer j = 0; j < 3; j++) {
//            char i = j.toString().charAt(0);
//            String country = "";
//            String language = "";
//            switch (i) {
//                case '1':
//                    country = "ru";
//                    language = "RU";
//                    System.out.println("\n" + i + " — русский");
//
//                    break;
//                case '2':
//                    country = "BY";
//                    language = "BE";
//                    System.out.println("\n" + i + " — белорусский");
//                    break;
//                default:
//                    System.out.println("\n" + i + " — английский");
//            }
//            Locale current = new Locale(language, country);
//            ResourceBundle rb = ResourceBundle.getBundle("by.it.verishko.jd02_05.ok.msg", current);
//            String s1 = rb.getString("msg.welcome");
//            System.out.println(s1);
//            String s2 = rb.getString("msg.myname");
//            System.out.println(s2);
//            String s3 = rb.getString("msg.howdoyoudo");
//            System.out.println(s3);
//        }
//    }
}
