package by.it.fando.jd01_15;

import java.io.*;

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
        String path1 = getPath(TaskB.class,"TaskB.java");
        String path2 = getPath(TaskB.class,"TaskB.txt");

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            String str;
            while ((str = br.readLine()) != null)
                sb.append(str).append("\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);


        try (PrintWriter pr = new PrintWriter(new FileWriter(path2))) {
            pr.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}