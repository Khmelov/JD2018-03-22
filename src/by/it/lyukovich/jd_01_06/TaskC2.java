package by.it.lyukovich.jd_01_06;

import java.util.Random;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        String s = Poem.text;
        Long timeStart = System.currentTimeMillis();
        String result = slow(s);
        Long timeEnd = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(timeEnd-timeStart + " мс");
        Long timeStart2 = System.currentTimeMillis();
        String result2 = fast(s);
        Long timeEnd2 = System.currentTimeMillis();
        System.out.println(result2);
        System.out.println(timeEnd2-timeStart2 + " мс");
    }

    static String slow (String text){
        String res="";
        Pattern p = Pattern.compile("\\s");
        String[] words = p.split(text.replaceAll("[\\s,;:.!?-]+|\\n", " "));
        Random r = new Random(10);
        while (res.length()<100000){

            res=res.concat(words[r.nextInt(words.length)].trim()).concat(" ");
        }
    return res;
    }

    static String fast (String text){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("\\s");
        String[] words = p.split(text.replaceAll("[\\s,;:.!?-]+|\\n", " "));
        Random r = new Random(10);
        while (sb.length()<100000){

           sb.append(words[r.nextInt(words.length)].trim()).append(" ");
        }
        return sb.toString();
    }
}
