package by.it.kovko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder(Poem.text);
        String regex = "[А-Яа-яёЁ]{4,}";
        Pattern p1= Pattern.compile(regex);
        Matcher m1= p1.matcher(Poem.text);
        while (m1.find()){
            System.out.println(m1.group());
            sb.setCharAt(m1.start()+3,'#');
                if (m1.group().length()>=7)
                    sb.setCharAt(m1.start()+6,'#');
        }
        System.out.println(sb.toString());
    }
}
