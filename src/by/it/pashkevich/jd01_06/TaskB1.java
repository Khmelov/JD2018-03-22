package by.it.pashkevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String regex = "[А-Яа-яёЁ]{2,}";
        Pattern p1= Pattern.compile(regex);
        Matcher m1= p1.matcher(Poem.text);
        char nachalo, konec;
        while (m1.find()) {
            nachalo=m1.group().charAt(0);
            konec=m1.group().charAt(m1.group().length()-1);
            if (!glas(nachalo) && glas(konec))
                System.out.println(m1.group());
        }
    }
    static boolean glas(char ch){
        char glasnye[]={'а','е','ё','и','о','у','ы','э','ю','я'};
        ch=Character.toLowerCase(ch);
        for (char vovel : glasnye) {
            if (ch==vovel)
                return true;
        }
        return false;
    }
}
