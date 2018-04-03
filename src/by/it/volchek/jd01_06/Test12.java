package by.it.volchek.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by volchek on 03.04.18.
 */
public class Test12 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
