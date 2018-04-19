package by.it.kovko.jd01_12;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    private static boolean parenthesisChecker(String text) {
        ArrayDeque<String> openParentheses = new ArrayDeque<>();
        Map<String, String> parenthesesMap = new HashMap<>();
        parenthesesMap.put("[", "]"); parenthesesMap.put("(", ")");
        parenthesesMap.put("{", "}"); parenthesesMap.put("<", ">");
        Matcher m = Pattern.compile("[\\[\\](){}<>]").matcher(text);
        while (m.find())
            if (m.group().matches("[\\[({<]"))
                openParentheses.addFirst(m.group());
            else if (!(parenthesesMap.get(openParentheses.pop())).equals(m.group()))
                return false;
        return openParentheses.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(parenthesisChecker(Text.program));
    }
}
