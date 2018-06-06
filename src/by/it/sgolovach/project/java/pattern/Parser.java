package by.it.sgolovach.project.java.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

    public boolean regEx(String expression, String patterns) {
        boolean answer = false;
        int count = 0;
        String pat = "";
        switch (patterns) {
            case "email":
                pat = "(\\w+)@(\\w+\\.)([a-z]{2,4})";
                count++;
                break;
            case "login":
                pat = "([\\w]{3,15})";
                count++;
                break;
            case "pass":
                pat = "([\\w]{3,15})";
                count++;
                break;
        }
        if (count > 0) {
            Pattern p = Pattern.compile(pat);
            Matcher m = p.matcher(expression);
            answer = m.matches();
        }
        return answer;
    }

//    public static void main(String[] args) {
//        String pat = "login";
//        String exx = "";
//        boolean b = regEx(exx, pat);
//        System.out.println(b);
//    }

}
