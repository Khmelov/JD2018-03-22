package by.it.verishko.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static HashMap<String, Integer> wordsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        StringBuilder word = new StringBuilder();
        while (!(str = sc.next()).equals("end")) word.append(str).append(" ");
        Matcher m = Pattern.compile("[A-Za-z']+").matcher(word);
        List<String> allWords = new ArrayList<>();
        while (m.find()) allWords.add(m.group());
        Collections.replaceAll(allWords, "isn't", "don't");
        Set<String> wordsSet = new HashSet<>(allWords);
        for (String w : wordsSet)
            wordsMap.put(w, Collections.frequency(allWords, w));
        System.out.println(wordsMap.toString());
    }
}

