package by.it.pashkevich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String path=TaskA.getPath(TaskB.class,"text.txt");
        System.out.println(path);
        StringBuilder text = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line=null;
            while(null!=(line=br.readLine())){
                text.append(line.trim()).append(' ');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher words = Pattern.compile("[А-Яa-яЁё]+").matcher(text);
        Matcher marks = Pattern.compile("[!,.:\\-]+").matcher(text);
        int wordsCount=0, marksCount=0;
        while(words.find()) ++wordsCount;
        while(marks.find()) ++marksCount;
        System.out.println("marks=" + marksCount + "\nwords=" + wordsCount);

        String fout = TaskA.getPath(TaskB.class, "resultTaskB.txt");
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))){
            pr.print("marks=" + marksCount + "\nwords=" + wordsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
