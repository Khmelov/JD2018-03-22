package by.it.shvedov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        StringBuilder words = new StringBuilder();
        while(!(line = scanner.next()).equals("end")) words.append(line).append(" ");
        Matcher m = Pattern.compile("[A-Za-z']+").matcher(words);
        List<String> allWords = new ArrayList<>();
        while (m.find()) allWords.add(m.group());
        Collections.replaceAll(allWords,"isn't", "don't");
        Set<String> wordsSet = new HashSet<>(allWords);
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : wordsSet)
            wordsMap.put(word, Collections.frequency(allWords, word));
        System.out.println(wordsMap.toString());
    }
}
