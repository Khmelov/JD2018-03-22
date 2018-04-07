package by.it.shekh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    private static String trimmer(String sent) {
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[,-;.?!:\\s]+");//добавляем в шаблон символы, которые нужно заменить пробелами в предложении
        Matcher matcher = pattern.matcher(sent);
        while (matcher.find()) {
            matcher.appendReplacement(sb," ");//добавляем и заменяем символ из шаблона на пробел
        }
        matcher.appendTail(sb);//дописываем оставшуюся часть предложения после appendReplacement
        return sb.toString().trim();//возврат предложения без начального и конечного пробелов
    }


    public static void main(String[] args) {

        String[] mas = Poem.text.split("[.?][\\n]");
        int sentences = mas.length;
        int stopper = 0;
        for (int i = 0; ; i++) {
            for (String s : mas) {
                if (trimmer(s).length() == i) {
                    System.out.println(trimmer(s));
                    stopper++;
                }
                if (stopper == sentences) break;
            }
        }
    }
}
