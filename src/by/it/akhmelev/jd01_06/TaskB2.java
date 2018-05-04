package by.it.akhmelev.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

/* kjdshf jdhsfkjhdsfk jhsdf
ldshfkldshfjkldjshf
 */


public class TaskB2 {
    public static void main(String[] args) {
        Arrays.stream(Poem.text.split("[.!?]")) //kjhfgksdfghsfdkgjh
                .map(s->s.trim().replaceAll("[^А-яёЁ]+"," "))
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
