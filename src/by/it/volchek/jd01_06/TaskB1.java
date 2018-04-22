package by.it.volchek.jd01_06;

import java.util.Arrays;
import java.util.regex.*;


/**
 * Created by volchek on 03.04.18.
 */
public class TaskB1 {
    final static char[] vowels = {'у', 'е', 'ы', 'а', 'о', 'э', 'ё', 'я', 'и', 'ю'};

    private static boolean checkWord(String s) {
        int flagVowelsStart = 0;
        int flagVowelsEnd = 0;
        char charStart = s.toLowerCase().charAt(0);
        char charEnd = s.toLowerCase().charAt((s.length() - 1));
        for (char c : vowels) {
            if (charStart == c) flagVowelsStart++;
            if (charEnd == c) flagVowelsEnd++;
        }
        if (flagVowelsStart < flagVowelsEnd) return true;
        else return false;
    }


    public static void main(String[] args) {
        String pattern = "[-,;:.!?\\s]+";
        String[] strMas = Poem.text.split(pattern);

        for (String s : strMas) {
            if (checkWord(s)) System.out.println(s);
        }

    }
}


