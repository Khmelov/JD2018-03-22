package by.it.fando.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(),"")
                .replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }

    public static void main(String[] args) {
        String fn = getPath(TaskB.class,"TaskB.txt");
        String fout = getPath(TaskB.class,"resultTaskB.txt");

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fn));
            String str;
            while((str = br.readLine()) != null)
                sb.append(str).append(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int cwords = 0;
        Matcher words = Pattern.compile("[А-Яа-яЁё]+").matcher(sb);
        while (words.find())
            cwords++;

        int cmarks = 0;
        Matcher marks = Pattern.compile("[-,.;!?:]+").matcher(sb);
        while (marks.find())
            cmarks++;

        System.out.println("words="+cwords+", "+"punctuation marks="+cmarks);

        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))) {
                pr.print("words="+cwords+", "+"punctuation marks="+cmarks);
            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}