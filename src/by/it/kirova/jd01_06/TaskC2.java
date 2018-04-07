package by.it.kirova.jd01_06;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String slowRes = slow(Poem.text);
        long end = System.nanoTime();
        long s = (end - start)/1000;
        System.out.println(s);

        start = System.nanoTime();
        String fastRes = fast(Poem.text);
        end = System.nanoTime();
        long f = (end - start)/1000;
        System.out.println(f);

        System.out.println("Сравнение на эквивалентность: " + slowRes.equals(fastRes));
        System.out.println("Отличие в скорости: " + (s/f));

    }


    private static String slow(String text) {
        String[] words = getWords(text);
        Random random = new Random(29);
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result = result.concat(words[random.nextInt(words.length)]);
        }
        return result;

    }

    private static String fast(String text) {
        String[] words = getWords(text);
        Random random = new Random(29);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb = sb.append(words[random.nextInt(words.length)]);
        }
        return sb.toString();
    }

    private static String[] getWords(String text) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(text);
        String[] w = new String[0];
        while (matcher.find()) {
            String word = matcher.group();
            int last = w.length;
            w = Arrays.copyOf(w, last + 1);
            w[last] = word;
        }
        return w;
    }
}
