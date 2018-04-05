package by.it.volchek.jd01_06;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created by volchek on 03.04.18.
 */
public class TaskC2 {
   private static String slow (String s){

       String pattern = "[.,!-:;\\s]+";
       String[] strMas = s.split(pattern);
        String slowString = strMas[(int)(Math.random()*strMas.length)];
        for (int i = 0; i < 9999; i++) {
            slowString=slowString+" "+strMas[(int)(Math.random()*strMas.length)];
        }
       return slowString;
    }
    private static String fast(String slowResult) {
        String pattern = " ";
        slowResult.trim();
        String[] strMas = slowResult.split(pattern);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <strMas.length ; i++) {

            sb.append(strMas[i]);
            if (i<(strMas.length-1))
            sb.append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String slowResult = slow(Poem.text);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(slowResult);
        System.out.println("Время работы slow: "+NANOSECONDS.toMillis(estimatedTime)+" миллисекунд");
        startTime = System.nanoTime();
        String fastResult = fast(slowResult);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println(fastResult);
        System.out.println("Время работы fast: "+NANOSECONDS.toMillis(estimatedTime)+" миллисекунд");

        System.out.println(slowResult.equals(fastResult));

    }
}
