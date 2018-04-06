package by.it.shekh.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    static String[] w = new String[0];
    static int count[] = new int[0];

    public static void main(String[] args) {

        Pattern pt = Pattern.compile("[а-яА-ЯёЁ]+");//шаблон для русского слова
        Matcher mtch = pt.matcher(Poem.text);
        while (mtch.find()) {
            String word = mtch.group();
            int p = pos(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = w.length;
                w = Arrays.copyOf(w, last + 1);
                count = Arrays.copyOf(count, last + 1);
                w[last] = word;
                count[last] = 1;
            }
        }
        for (int i = 0; i <w.length ; i++) {
            System.out.println(w[i]+"="+count[i]);
        }
    }

    private static int pos(String word) {
        for (int i = 0; i < w.length; i++) {
            if (word.equals(w[i]))
                return i;
        }
        return -1;
    }
}
