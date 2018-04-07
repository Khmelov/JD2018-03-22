package by.it.sgolovach.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern patern = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher = patern.matcher(Poem.text);
        while (matcher.find()) {
            sb.setCharAt(matcher.start() + 3, '#');
            if (matcher.group().length() >= 7) sb.setCharAt(matcher.start() + 6, '#');
        }
        System.out.println(sb.toString());
    }
}
