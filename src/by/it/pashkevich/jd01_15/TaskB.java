package by.it.pashkevich.jd01_15;

import java.io.*;

public class TaskB {

    public static void main(String[] args) {
        String txt = TaskA.getPath(TaskB.class, "TaskB.java");
        String txtOut = TaskA.getPath(TaskB.class, "TaskB.txt");
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(txt))) {
            String line;
            while ((line=reader.readLine())!=null) text.append(line).append('\n');
            } catch (IOException e) {
            e.printStackTrace();
        }
        int startIndex, endIndex;
        while ((startIndex=text.indexOf("\u002f*"))>=0 && (endIndex=text.indexOf("*\u002f"))>=0){ text.delete(startIndex, endIndex+2);}
        while ((startIndex=text.indexOf("\u002f/"))>=0 && (endIndex=text.indexOf("\n",startIndex))>=0){ text.delete(startIndex, endIndex);}
        try(PrintWriter printer = new PrintWriter(new FileWriter(txtOut))){
            printer.print(text);
            System.out.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
