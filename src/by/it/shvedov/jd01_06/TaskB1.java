package by.it.shvedov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TaskB1 {
    public static void main(String[] args) {
        //StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        String[] soglasny = {"Б", "В", "Г", "Д", "Ж", "З", "К", "Л", "М", "Н", "П", "Р", "С", "Т", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "б", "в", "г", "д", "ж", "з", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х", "ц", "ч", "ш", "щ"};
        String[] glasny={"Ё","У","Е","Ы","А","О","Э","Я","И","Ю","ё","у","е","ы","а","о","э","я","и","ю",};
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            for (int i = 0; i < soglasny.length; i++) {
                if (word.startsWith(soglasny[i])) {
                  for(int j=0; j<glasny.length; j++) {
                      if(word.endsWith(glasny[j])) System.out.println(word);
                  }
                }
            }
        }
    }
}