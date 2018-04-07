package by.it.desykevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        String word;
        Pattern p= Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m=p.matcher(Poem.text);
        while (m.find()){
            word=m.group();
            System.out.print(check(word)?word+" "+"\n": "");
        }
    }

    private static boolean check (CharSequence word){
        char[] vowel= {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю',
                'я', 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я',};
        for (char letter:vowel)
        {
         if (word.charAt(0)==letter)return false;
        }
        for (char letter:vowel) {
            if (word.charAt(word.length()-1)==letter)return true;
            
        }
        return false;
    }
}
