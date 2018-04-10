package by.it.sgolovach.jd01_06;

import java.util.Arrays;

public class TaskB1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        wordNoRegex(sb);
    }

    private static void wordNoRegex(StringBuilder sb) {
        String str = new String(sb);
        char[] ch = str.toCharArray();
        String[] word = new String[0];
        StringBuffer sbs = new StringBuffer();

        int a = 0, b = 0;
        for (char c : ch) {
            if (c == ',' || c == '.' || c == '-' || c == ' ' || c == '!' || c == ':' || c == '\n') a++;
            if (a == 1) {
                b++;
            }
            if (c >= 'а' && c <= 'я' || c == 'ё' || c >= 'А' && c <= 'Я' || c == 'Ё' || a == 0) {
                sbs.append(c);
            } else {
                String strr = new String(sbs);
                word = Arrays.copyOf(word, b + 1);
                word[b] = strr;
                sbs.delete(0, sbs.length());
            }
            a = 0;
        }


        for (int i = 0; i < word.length; i++) {
            int j = 0;
            int f = 0, l = 0;
            if (word[i] != null) {
                sbs.append(word[i]);
                if (sbs.length() >= 2) {
                    String str1 = new String(sbs);
                    char[] ch1 = str1.toCharArray();
                    if (ch1[0] >= 'б' && ch1[0] <= 'д' || ch1[0] >= 'ж' && ch1[0] <= 'з' || ch1[0] >= 'к' && ch1[0] <= 'н' || ch1[0] >= 'п' && ch1[0] <= 'т' || ch1[0] >= 'ф' && ch1[0] <= 'щ' || ch1[0] >= 'Б' && ch1[0] <= 'Д' || ch1[0] >= 'Ж' && ch1[0] <= 'З' || ch1[0] >= 'К' && ch1[0] <= 'Н' || ch1[0] >= 'П' && ch1[0] <= 'Т' || ch1[0] >= 'Ф' && ch1[0] <= 'Щ')
                        f++;
                    if (ch1[ch1.length - 1] == 'а' || ch1[ch1.length - 1] == 'о' || ch1[ch1.length - 1] == 'и' && ch1[ch1.length - 1] != 'й' || ch1[ch1.length - 1] == 'е' || ch1[ch1.length - 1] == 'ё' || ch1[ch1.length - 1] == 'э' || ch1[ch1.length - 1] == 'ы' || ch1[ch1.length - 1] == 'у' || ch1[ch1.length - 1] == 'ю' || ch1[ch1.length - 1] == 'я' || ch1[ch1.length - 1] == 'А' || ch1[ch1.length - 1] == 'О' || ch1[ch1.length - 1] == 'И' || ch1[ch1.length - 1] == 'Е' || ch1[ch1.length - 1] == 'Ё' || ch1[ch1.length - 1] == 'Э' || ch1[ch1.length - 1] == 'Ы' || ch1[ch1.length - 1] == 'У' || ch1[ch1.length - 1] == 'Ю' || ch1[ch1.length - 1] == 'Я')
                        l++;
                }
                if (f == 1 && l == 1) {
                    System.out.println(word[i]);
                }
                sbs.delete(0, sbs.length());
            }
        }
    }


}
