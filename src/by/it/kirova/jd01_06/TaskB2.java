package by.it.kirova.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        /*При нахождении в тексте строк с [.!?] (встречаются 1 или более раз подряд) сравнивает с паттерном
         "пробел" + "большая буква из интервала" при помощи lookahead, исключая тем самым многоточия и другие
         знаки препинания, являющиеся ЧАСТЬЮ предложения, стоящие:
         а) в начале предложения:
            Мышь не удостоила его ответом и торопливо продолжала: "...Нашёл это благоразумным
             и решил вместе с Эдгаром Этелингом отправиться к Вильгельму и предложить ему корону»
         б) в середине предложения (усиление слова/ пропущенное слово в цитате/ шаблон записи):
            "Там русский дух... там Русью пахнет!"
            Пушкин писал: "А поэзия... должна быть глуповата"
            Труба длиной 5...10 м.
         */
        Pattern p = Pattern.compile("([.!?]+)\\s(?=[А-ЯЁ])");
        String[] lines = p.split(Poem.text);

        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replaceAll("[\\s,;:.!?-]+|\\n", " ");
            lines[i] = lines[i].trim();
        }

        Comparator<String> stringLengthComparator = new StringLengthSort();

        Arrays.sort(lines, stringLengthComparator);
        for (String element: lines) {
            System.out.println(element);
        }
    }
}
