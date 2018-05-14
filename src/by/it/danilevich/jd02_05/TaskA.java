package by.it.danilevich.jd02_05;

//import java.text.DateFormat;
//import java.text.ParseException;
import java.time.Year;
import java.util.Date;
import java.util.Locale;
//import java.util.ResourceBundle;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        ResourceManager rm = ResourceManager.INSTANCE;
        System.out.println("Выберите язык вывода: ru/be/en");
        Scanner scanner = new Scanner(System.in);
        String rez = scanner.nextLine();

        if (args.length<2){
            rm.setLocale("msg",Locale.getDefault());
        }
        else{
            rm.setLocale("msg",new Locale(args[0],args[1]));
        }

        String lang = "ru";
        String country = "RU";
        if(rez.equals("en")){
                lang = "en";
                country = "US";
        }
        else if (rez.equals("be")){
                lang = "be";
                country = "BY";
        }

        Locale curlocale = new Locale(lang,country);
        rm.setLocale("msg",curlocale);
        System.out.println(rm.get(Messages.WELCOME));
        System.out.println(rm.get(Messages.YourQuestion));
        System.out.println(rm.get(Messages.MYNAME));


        rm.setLocale("month",curlocale);
        Date d = new Date();
        String s = rm.get(Month.arMONTH[d.getMonth()]);

        System.out.println(d.getDate() +" " + s + " " + Year.now().getValue());

    }

}

