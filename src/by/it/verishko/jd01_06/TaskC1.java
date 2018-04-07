package by.it.verishko.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("//n");
        String[] strings = pattern.split(Poem.text);
        int[] counter = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
            counter[i] = strings[i].length();
            System.out.println(strings[i]);
        }
    }
}
