package by.it.volchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by volchek on 03.04.18.
 */


public class TaskB2 {
    private static String stringConvert(String sentence) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[-,;:.!?\\s]+");
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            matcher.appendReplacement(sb, " ");
        }
        matcher.appendTail(sb);
        String finalSentence = sb.toString();
        return finalSentence.trim();
    }


    public static void main(String[] args) {

        //StringBuilder sb = new StringBuilder();
        String pattern = "[.?!][\\n]";
        String[] strMas = Poem.text.split(pattern);
        int sentenceNumber = strMas.length;
        int flag = 0;
        for (int i = 0; i < 200; i++) {
            for (String s : strMas) {
                if (stringConvert(s).length() == i) {
                    System.out.println(stringConvert(s));
                    flag++;
                }
                if (flag == sentenceNumber) break;
            }
        }
    }


}




