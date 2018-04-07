package by.it.fando.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {

    public static void main(String[] args) {

        String[] sent = Poem.text.split("[.?!]");

        for (int i = 0; i < sent.length; i++) {
            sent[i] = sent[i].replaceAll("[^А-Яа-яЁё \\n]","").replaceAll("\\n"," ");
            sent[i] = sent[i].trim();
        }

        Comparator<String> stringLengthComparator = new StringLengthSort();

        Arrays.sort(sent, stringLengthComparator);
        for (String element: sent) {
            System.out.println(element);
        }
    }

    private static class StringLengthSort implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }
}
