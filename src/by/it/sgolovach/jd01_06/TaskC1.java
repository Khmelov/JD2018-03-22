package by.it.sgolovach.jd01_06;

import java.text.Format;
import java.util.Arrays;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskC1 {

    static String[] str = new String[0];


    public static void main(String[] args) {
        String all = new String(Poem.text);
        String r1 = "\\n";
        String repl = " ";

        StringBuilder sb = new StringBuilder();
        char[] ch = all.toCharArray();
        int a = 0, sum = 0;
        for (char c : ch) {
            sb.append(c);
            if (c == '\n') a++;
            if (a == 1 || sum== ch.length-1) {
                String str1 = new String(sb);
                int last = str.length;
                str = Arrays.copyOf(str, last + 1);
                str[last] = str1;
                sb.delete(0, sb.length());
            }
            sum++;
            a = 0;

        }

        for (int i = 0; i < str.length; i++) {
            str[i] = replaceAll(str[i], r1, repl);
            str[i] = str[i].trim();
        }

        int max = findMax(str);

        for (int i = 0; i < str.length; i++) {
            str[i] = reFormat(str[i], max);
        }
        for (String s : str) {
            System.out.println(s);
        }
    }

    private static String replaceAll(String str, String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            str = matcher.replaceAll(replacement);
        }
        return str;

    }

    static int findMax(String[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            int max = arr[0].length();
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i].length()) max = arr[i].length();
            }
            return max;
        }
    }

    static String reFormat(String str, int max) {
        StringBuilder sb = new StringBuilder(str);
        int sum = max - str.length();
        char[] ch = str.toCharArray();
        int a = 0;
        int b = 0, d = 0;
        if (sum > 0) {
            for (char c : ch) {
                if (c == ' ') a++;
            }
        }

        if (sum > 0) {
            b = sum / a;
            d = sum % a;
            if (b > 0 && d == 0) str = format1(str, b);
            if (b > 0 && d > 0) str = format2(str, b, d);
            if (b == 0 && d > 0) str = format3(str, d);
        }
        return str;
    }


    static String format1(String str, int b) {
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        char ch1 = ' ';

        for (char c : ch) {
            sb.append(c);
            if (c == ' ') {
                for (int i = 0; i < b; i++) {
                    sb.append(ch1);
                }
            }
        }

        return sb.toString();
    }

    private static String format2(String str, int b, int d) {
        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        char ch1 = ' ';
        int sum = 0;

        for (char c : ch) {
            sb.append(c);
            if (c == ' ' && sum < d) {
                sum++;
                for (int i = 0; i < b + 1; i++) {
                    sb.append(ch1);
                }

            } else if (c == ' ') {
                for (int i = 0; i < b; i++) {
                    sb.append(ch1);
                }
            }
        }

        return sb.toString();
    }

    private static String format3(String str, int d) {

        StringBuilder sb = new StringBuilder();
        char[] ch = str.toCharArray();
        char ch1 = ' ';
        int sum = 0;

        for (char c : ch) {
            sb.append(c);
            if (c == ' ' && sum < d) {
                sum++;
                sb.append(ch1);
            }
        }

        return sb.toString();
    }
}
