package by.it.poprugo.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] w = new String[0]; //or w={}
    private static int[] count = new int[0]; //or count={}

    private static int pos(String word) {
        for (int i = 0; i < w.length; i++) {
            if (word.equals(w[i]))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p = pos(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = w.length; //index of last element
                w = Arrays.copyOf(w, last + 1);
                w[last] = word; //fix the word
                count=Arrays.copyOf(count, last+1);
                count[last] = 1;
            }
        }
        for (int i = 0; i < w.length; i++) {
            System.out.println(w[i] + "="+count[i]);
        }
    }
}