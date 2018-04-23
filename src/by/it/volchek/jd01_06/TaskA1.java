package by.it.volchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by volchek on 03.04.18.
 */
public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            sb.setCharAt(matcher.start() + 3, '#');
            if (matcher.group().length() >= 7)
                sb.setCharAt(matcher.start() + 6, '#');

        }
        System.out.println(sb.toString());
    }

}
