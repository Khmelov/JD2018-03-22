package by.it.volchek.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by volchek on 03.04.18.
 */
public class TaskA2 {
    static String[] w = new String[0];
    static int[] count = new int[0];

    private static int pos(String word) {
        for (int i = 0; i < w.length; i++) {
            if (word.equals(w[i]))
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("[а-яА-ЯЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
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
        for (int i = 0; i < w.length; i++) {
            System.out.println(w[i] + "=" + count[i]);

        }
    }


}
