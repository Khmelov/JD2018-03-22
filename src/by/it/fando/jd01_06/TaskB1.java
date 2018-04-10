package by.it.fando.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);
        char start;
        char finish;

        while (matcher.find()) {
            start = matcher.group().charAt(0);
            finish = matcher.group().charAt(matcher.group().length() - 1);
            if (!vowel(start) && vowel(finish))
                System.out.println(matcher.group());
        }
    }

    private static boolean vowel(char v) {
            char [] vow = {'а','е','ё','и','о','у','ы','э','ю','я','А','Е','Ё','И','О','У','Ы','Э','Ю','Я'};
            for (char c : vow) {
                if (v==c)
                    return true;
            }
            return false;
    }
}