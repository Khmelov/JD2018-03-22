package by.it.fando.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        StringBuilder sb = new StringBuilder();
        while(!(str = scanner.next()).equals("end"))
            sb.append(str).append(" ");
        Matcher m = Pattern.compile("[A-Za-z']+").matcher(sb);
        List<String> words = new ArrayList<>();
        while (m.find())
            words.add(m.group());

        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 0);
            }
            wordCount.put(word, wordCount.get(word) + 1);
        }
        for (String word : wordCount.keySet()) {
            System.out.println(word + "=" + wordCount.get(word));
        }
    }
}
