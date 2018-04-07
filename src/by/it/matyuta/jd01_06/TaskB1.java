package by.it.matyuta.jd01_06;


import java.util.ArrayList;
import java.util.List;

public class TaskB1 {


    public static void main(String[] args) {

        String p = Poem.text;
        String[] words = p.split(" ");
        char gla[] = {'А', 'Е', 'И', 'О', 'У', 'Ю', 'Я', 'Ы', 'Ё', 'Э', 'а', 'е', 'и', 'о', 'у', 'ю', 'я', 'ы', 'ё', 'э'};
        char sog[] = {'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'К', 'Л', 'М', 'Н', 'П', 'Р', 'С', 'Т', 'Ф', 'Х', 'Ч', 'Ц', 'Ш', 'Щ',
                      'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ч', 'ц', 'ш', 'щ'};
        int i;
        for (i = 0; i < words.length; i++) {
            for (int j = 0; j < gla.length; j++) {
                for (int k = 0; k < sog.length; k++) {

                    char firstChar = words[i].charAt(0);
                    char lastChar = words[i].charAt(words.length - 1);

                    if (firstChar == gla[j] && lastChar == sog[k]) {
                        System.out.println(words[i]);
                    }
                }
            }
//            if (words[i].startsWith("А"))
//                if (words[i].endsWith("ч"))

        }
    }
}