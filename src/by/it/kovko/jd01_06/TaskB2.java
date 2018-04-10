package by.it.kovko.jd01_06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String sentences[];
        String regex="[.]", regexForSentences="[^А-Яа-яёЁ]+", replacement=" ";
        Pattern p = Pattern.compile(regexForSentences);
        sentences=Poem.text.replaceAll("\\.{3}"," ").split(regex);
        //sentences=Poem.text.split(regex);
        StringBuilder sb[] = new StringBuilder[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            Matcher m = p.matcher(sentences[i]);
            sb[i] = new StringBuilder(m.replaceAll(replacement).trim());
        }

        Comparator<StringBuilder> comparatorSB = new CompSB();
        Arrays.sort(sb,comparatorSB);
        for (StringBuilder stringBuilder : sb)
            System.out.print(stringBuilder.toString()+"\n");
    }
}
