package by.it.akhmelev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB1 {

    private static boolean ok(String word){
        String glas="уеэоаыяиюёУЕЭОАЫЯИЮЁ";
        return (glas.indexOf(word.charAt(0))<0 &&
                glas.indexOf(word.charAt(word.length()-1))>=0);
    }

    public static void main(String[] args) {
        Pattern p=Pattern.compile("[А-яЁё]+");
        Matcher m=p.matcher(Poem.text);
        while (m.find()){
            if (ok(m.group()))
                System.out.println(m.group());
        }
    }
}
