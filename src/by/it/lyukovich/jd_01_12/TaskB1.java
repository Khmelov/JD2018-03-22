package by.it.lyukovich.jd_01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        StringBuilder sb = new StringBuilder();
        while(!(string = scanner.next()).equals("end")) sb.append(string).append(" ");
        Matcher m = Pattern.compile("[A-Za-z']+").matcher(sb);
        List<String> wordList = new ArrayList<>();
        while (m.find()) wordList.add(m.group());
        Collections.replaceAll(wordList,"isn't", "don't");
        Set<String> words = new HashSet<>(wordList);
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words)
            wordsMap.put(word, Collections.frequency(wordList, word));
        System.out.println(wordsMap.toString());
    }
}
