package by.it.kirova.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;
        StringBuilder sb = new StringBuilder();
        while (!(str = scanner.nextLine()).equals("end")) {
            sb.append(str + "\n");
        }
        wordsCount(sb.toString());
    }

    private static void wordsCount(String text) {
        Pattern pattern = Pattern.compile("\\w+('\\w)*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group();
//          int count = map.containsKey(word) ? map.get(word) : 0;
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            System.out.println(entry);
        }


    }
}



