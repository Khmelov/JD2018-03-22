package by.it.volchek.jd01_06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created by volchek on 03.04.18.
 */
public class TaskC2 {
    final static int iteration = 10000;

    private static String slow(String s) {

        String pattern = "[.,!-:;\\s]+";
        String[] strMas = s.split(pattern);
        Random rnd1 = new Random(1000);
        String slowString = strMas[rnd1.nextInt(strMas.length)];
        for (int i = 0; i < iteration - 1; i++) {
            slowString = slowString + " " + strMas[rnd1.nextInt(strMas.length)];
        }
        return slowString;
    }

    private static String fast(String s) {
        String pattern = "[.,!-:;\\s]+";
        String[] strMas = s.split(pattern);
        Random rnd2 = new Random(1000);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iteration; i++) {

            sb.append(strMas[rnd2.nextInt(strMas.length)]);
            if (i < iteration - 1)
                sb.append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        long startTime = System.nanoTime();
        String slowResult = slow(Poem.text);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(slowResult);
        long slowTime = NANOSECONDS.toMillis(estimatedTime);

        startTime = System.nanoTime();
        String fastResult = fast(Poem.text);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(fastResult);
        System.out.println("Время работы slow: " + slowTime + " миллисекунд");
        System.out.println("Время работы fast: " + NANOSECONDS.toMillis(estimatedTime) + " миллисекунд");
        System.out.println(slowResult.equals(fastResult));

    }
}
