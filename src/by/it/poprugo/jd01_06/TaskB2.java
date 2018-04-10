package by.it.poprugo.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        //Poem.text.replaceAll("[\\.]{3}", " ");
        String[] sent = Poem.text.split("[.!?]+");
        for (int i = 0; i < sent.length; i++) {
            sent[i] = sent[i].replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
        }
        boolean flag;
        int last = sent.length - 1;
        do {
            flag = false;
            for (int i = 0; i < last; i++) {
                if (sent[i].length() > sent[i + 1].length()) {
                    String temp = sent[i];
                    sent[i] = sent[i + 1];
                    sent[i + 1] = temp;
                    flag = true;
                }
            }
            last--;
        } while (flag);
        for (String s : sent) {
            System.out.println(s);
        }
    }
}