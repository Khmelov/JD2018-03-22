package by.it.verishko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;

    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        path += cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path;

    }

    public static void main(String[] args) {
        String fn = getPath(TaskB.class, "text.txt");
        String fout = getPath(TaskB.class, "resultTaskB.txt");
        System.out.println(fn);
        String line;
        int wordsCount = 0, marksCount = 0;
        StringBuffer sb = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher words = Pattern.compile("[А-Яa-яЁё]+").matcher(sb);
        Matcher marks = Pattern.compile("[!,.:\\-]+").matcher(sb);
        while (words.find()) ++wordsCount;
        while (marks.find()) ++marksCount;
        System.out.println("marks=" + marksCount + "\nwords=" + wordsCount);
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))) {
            pr.print("marks=" + marksCount + "\nwords=" + wordsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
