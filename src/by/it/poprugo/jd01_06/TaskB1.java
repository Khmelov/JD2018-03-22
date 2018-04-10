package by.it.poprugo.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static boolean comp(String word) {
        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        char start = word.charAt(0);
        char fin = word.charAt(word.length() - 1);
        return ((vowels.indexOf(start)) < 0 && (vowels.indexOf(fin)) >= 0);
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String w = matcher.group();
            if (comp(w)) System.out.println(w);
        }
    }
}