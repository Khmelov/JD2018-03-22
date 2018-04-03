package by.it.shekh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pt = Pattern.compile("[а-яА-ЯёЁ]{4,}");//шаблон для русского слова
        Matcher mtch = pt.matcher(Poem.text);
        while (mtch.find()) {
            sb.setCharAt(mtch.start() + 3, '#');
            if(mtch.group().length()>=7)
                sb.setCharAt(mtch.start() + 6, '#');
        }
        System.out.println(sb.toString());

    }
}
