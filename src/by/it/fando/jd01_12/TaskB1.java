package by.it.fando.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String [] words = str.replaceAll("[^a-zA-Z']"," ").split("\\s+");
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
