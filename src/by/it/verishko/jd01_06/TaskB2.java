package by.it.verishko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

//public class TaskB2 {
//    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("[.?!][\\n]");
//        String[] lines = pattern.split(Poem.text);
//        for (int i = 0; i < lines.length; i++) {
//            lines[i] = lines[i].replaceAll("[\\s,;:.!?-]+|\\n", " ");
//            lines[i] = lines[i].trim();
//        }
//        Comparator<String> stringLengthComparator = new StringLengthSort();
//        Arrays.sort(lines, stringLengthComparator);
//        for (String element : lines) {
//            System.out.println(element);
//        }
//    }
//
//    static class StringLengthSort implements Comparator<String> {
//        public int compare(String s1, String s2) {
//            return Integer.compare(s1.length(), s2.length());
//        }
//    }
//}





















public class TaskB2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[.?!][\\n]");
        String[] lines = pattern.split(Poem.text);
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
            lines[i] = lines[i].replaceAll("[\\s,;:.!?-]+|\\n", " ");
        }

    }
}














