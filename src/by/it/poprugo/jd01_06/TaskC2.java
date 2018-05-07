package by.it.poprugo.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    private static String[] extractWords(String line) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            sb.append(matcher.group()).append(' ');
        }
        //System.out.println(sb);
        String[] wordArr = sb.toString().trim().split(" ");
        return wordArr;
    }

    private static String slow(String text) {
        String dictSl = "";
        Random rand = new Random(35);
        String[] words = extractWords(text);
        do {
            int ind = rand.nextInt(words.length);
            dictSl = dictSl.concat(words[ind]).concat(" ");
        } while (dictSl.length() <= 100000);
        return dictSl.trim();
    }

    private static String fast(String text) {
        String dictF = "";
        Random rand = new Random(35);
        String[] words = extractWords(text);
        StringBuilder sbb = new StringBuilder();
        do {
            int ind = rand.nextInt(words.length);
            sbb.append(words[ind]).append(" ");
        } while (sbb.length() <= 100000);
        dictF = sbb.toString();
        return dictF.trim();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = slow(Poem.text);
        System.out.println("time (slow): " + (System.nanoTime() - start) / 1000);
        System.out.println(str);

        start = System.nanoTime();
        str = fast(Poem.text);
        System.out.println("time (fast): " + (System.nanoTime() - start) / 1000);
        System.out.println(str);
    }
}