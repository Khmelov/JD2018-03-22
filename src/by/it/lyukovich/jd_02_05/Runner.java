package by.it.lyukovich.jd_02_05;

import java.text.DateFormat;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Runner {
    static String language="";
    static String country="";
    static Locale current = new Locale(language, country);
    static DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(language, country));

    public static void main(String[] args) {
        String path = "by.it.lyukovich.jd_02_05.locale", myname, string="";
        Scanner sc=new Scanner(System.in);
        System.out.print("Pick your language, type en, ru or be ");
        string=sc.next();
        ResourceBundle rb = ResourceBundle.getBundle(path, setLocale(string));
        System.out.println(rb.getString("msg.PickedLang"));
        System.out.print(rb.getString("msg.WhatName") + " ");
        myname = sc.next();
        System.out.printf(rb.getString("msg.Hello") + "\n", myname);
        System.out.println(rb.getString("msg.PickLang"));
        while (!string.equalsIgnoreCase("end")){
            string = sc.nextLine();
            if (string.contains("pick")){
                try {
                    String[] s = string.split("\\s+");
                    if (s.length>2) {rb = ResourceBundle.getBundle(path, setLocale(s[1], s[2]));}
                    else if (s.length==2) {rb = ResourceBundle.getBundle(path, setLocale(s[1]));}
                    else rb = ResourceBundle.getBundle(path, setLocale(string));
                    System.out.println(rb.getString("msg.PickedLang"));
                    df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(language, country));
                    System.out.println(rb.getString("msg.curDate") + df.format(new Date()) +"\n"+ rb.getString("msg.curLang") +
                            current.getDisplayLanguage() + "\n"+rb.getString("msg.curCountry") + current.getDisplayCountry() + "\n");
                } catch (NullPointerException e){
                    rb = ResourceBundle.getBundle(path, setLocale(string));
                }
            }
            if (string.equalsIgnoreCase("hi")) System.out.printf(rb.getString("msg.Hello") + "\n", myname);
        }
        System.out.printf(rb.getString("msg.Bye"), myname);
    }
    private static Locale setLocale (String s){
        switch (s){
            case "en" : language = "en"; country = "GB"; break;
            case "ru" : language = "ru"; country = "RU"; break;
            case "be" : language = "be"; country = "BY"; break;
            default : language = "en"; country = "GB"; break;
        }
        current = new Locale(language, country);
        return current;
    }
    private static Locale setLocale (String s, String s2){
        switch (s){
            case "en" : language = "en"; break;
            case "ru" : language = "ru"; break;
            case "be" : language = "be"; break;
            default : language = "en"; break;
        }
        switch (s2){
            case "GB" : country = "GB"; break;
            case "RU" : country = "RU"; break;
            case "BY" : country = "BY"; break;
            default: country = "GB"; break;
        }
        current = new Locale(language, country);
        return current;
    }
}
