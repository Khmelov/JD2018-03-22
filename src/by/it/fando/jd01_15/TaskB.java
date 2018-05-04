package by.it.fando.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Отрабатываем потоки ввода и вывода
 * Вдруг когда-нибудь пригодится.
 */

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
//      Присвоили путь

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            String str;
            while ((str = br.readLine()) != null)
                sb.append(str).append("\n");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        int start;
        int finish;
        while ((start = sb.indexOf("/\u002f")) >= 0 && (finish = sb.indexOf("\n",start)) >= 0 ) {
            sb.delete(start,finish+1);
        }
        while ((start = sb.indexOf("\u002f*")) >= 0 && (finish = sb.indexOf("*\u002f")) >= 0 ) {
            sb.delete(start,finish+2);
        }

//        try {
//            Stream<String> text = Files.lines(Paths.get(path1))
//                    .filter(t -> !t.contains("/") || !t.contains("/*"))
//                    .
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(sb);
        /* Вывели в консоль код из этого файла */

        try (PrintWriter pr = new PrintWriter(new FileWriter(path2))) {
            pr.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Продублировали код из этого файла
        в файл с расширением .txt
         */
    }
}