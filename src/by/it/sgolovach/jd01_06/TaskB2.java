package by.it.sgolovach.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    static String[] str = new String[0];


    public static void main(String[] args) {
        String all = new String(Poem.text);
        String r1 = "\\.{2,}";
        String r2 = "\\n";
        String r3 = "\\-";
        String r4 = "\\:";
        String r5 = "\\!";
        String r6 = "\\,";
        String r7 = "\\s{2,}";
        String r8 = "\\.";
        String repl = " ";

        all = replaceAll(all, r1, repl);
        all = replaceAll(all, r2, repl);
        all = replaceAll(all, r3, repl);
        all = replaceAll(all, r4, repl);
        all = replaceAll(all, r5, repl);
        all = replaceAll(all, r6, repl);
        all = replaceAll(all, r7, repl);

        StringBuilder sb = new StringBuilder();

        char[] ch = all.toCharArray();
        int a = 0;
        for (char c : ch) {
            sb.append(c);
            if (c == '.') a++;
            if (a == 1) {
                String str1 = new String(sb);
                int last = str.length;
                str = Arrays.copyOf(str, last + 1);
                str[last] = str1;
                sb.delete(0, sb.length());
            }
            a = 0;

        }

        for (int i = 0; i < str.length; i++) {
            str[i] = replaceAll(str[i], r8, repl);
            str[i] = str[i].trim();
        }

        sort(str);
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

    static void sort(String[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    String buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);

    }
}
