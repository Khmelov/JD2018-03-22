package by.it.kovko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    static private String w[]=new String[0];
    static private int count[]=new int[0];

    private static int pos(String word) {
        for (int i = 0; i < w.length; i++) {
            if (word.equals(w[i]))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        //StringBuilder sb= new StringBuilder(Poem.text);
        String regex = "[А-Яа-яёЁ]+";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()) {
            String word = m1.group();
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
            for (int i = 0; i < w.length; i++) {
                System.out.println(w[i] + "=" + count[i]);
            }
        }
    }
}


