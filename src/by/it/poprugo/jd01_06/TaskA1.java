package by.it.poprugo.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        // сделаем место, где будет лежать эта поэма
        StringBuilder sb = new StringBuilder(Poem.text);
        // "[а-яА-ЯёЁ]+" - pattern to all Russian words
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        //чтобы слова - длиной > 4 рег.в.: "[а-яА-ЯёЁ]{4,}"
        Matcher matcher = pattern.matcher(Poem.text); //"беать" по Poem.text
        while (matcher.find()) {
            if (matcher.group().length() >= 4)
                sb.setCharAt(matcher.start() + 3, '#');
            if (matcher.group().length() >= 7) {
                sb.setCharAt(matcher.start() + 6, '#');
            }
        }
        System.out.print(sb);
    }
}