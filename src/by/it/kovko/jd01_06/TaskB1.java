package by.it.kovko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        //StringBuilder sb= new StringBuilder(Poem.text);
        String regex = "[А-Яа-яёЁ]{2,}";
        Pattern p1= Pattern.compile(regex);
        Matcher m1= p1.matcher(Poem.text);
        char start, end;
        while (m1.find()) {
            start=m1.group().charAt(0);
            end=m1.group().charAt(m1.group().length()-1);
            if (!isVovel(start) && isVovel(end))
                System.out.println(m1.group());
        }
    }
    static boolean isVovel(char ch){
        char vovels[]={'а','е','ё','и','о','у','ы','э','ю','я'};
        ch=Character.toLowerCase(ch);
        for (char vovel : vovels) {
            if (ch==vovel)
                return true;
        }
        return false;
    }
}
