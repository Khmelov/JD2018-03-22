package by.it.sgolovach.jd01_14;

import java.io.*;
import java.util.Scanner;

public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }


    public static void main(String[] args) throws IOException {
        String src = dir(TaskB.class);
        String filename = src + "text.txt";
        File f = new File(filename);
//        File f1 = new File(filename);
        Scanner scan = new Scanner(f);
        scan.useDelimiter("[^А-яЁ-ё]+");
        int word = 0;
        while (scan.hasNext()) {
            scan.next();
            word++;
        }
        scan.close();

        Scanner scan1 = new Scanner(f);
        scan1.useDelimiter("[^-.():;!,]+");
        int punctuation = 0;
        while (scan1.hasNext()) {
            scan1.next();
            punctuation++;
        }
        scan1.close();
        try (PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))) {

            out2.print("words=" + word + ",punctuation marks=" + punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("words=" + word + ",punctuation marks=" + punctuation);
    }

}
//"[-.():;!,\\s]*"