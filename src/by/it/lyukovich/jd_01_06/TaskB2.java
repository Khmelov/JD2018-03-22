package by.it.lyukovich.jd_01_06;


import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("([.!?]+)\\s(?=[А-ЯЁ])");
        String[] lines = p.split(Poem.text);
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replaceAll("[\\s,;:.!?-]+|\\n", " ");
            lines[i] = lines[i].trim();
        }
        Arrays.sort(lines, Comparator.comparingInt(String::length));
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }

    }






}
