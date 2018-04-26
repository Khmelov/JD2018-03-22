package by.it.sgolovach.jd01_15;


import java.io.*;

// first comment
public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
/*
finish main
*/

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(dir(TaskB.class) + "TaskB.java"))) {
            boolean one = false, more = false, doc = false, fin = false;
            int slash = 0, star = 0, count = 0;
            String line;
            while ((line = br.readLine()) != null) {
                slash = 0;
                star = 0;
                char[] ch = line.toCharArray();
                for (char c : ch) {
                    if (c == '/') slash++;
                    if (c == '*') star++;
                    if (slash == 2) one = true;
                    if (slash == 1 && star == 1) {
                        more = true;
                        doc = true;
                        count++;
                    }
                    if (slash == 1 && star == 1 && count > 1) {
                        fin = true;
                        count = 0;
                    }
                }

                if (!one && !more && !doc && !fin) {
                    sb.append(line).append("\n");
                }

                if (one || more && doc && fin) {
                    sb.append("\n");
                }
                one = false;
                if (fin) {
                    more = false;
                    doc = false;
                    fin = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(sb.toString());

/*
start main
*/

        try (PrintWriter out = new PrintWriter(new FileWriter(dir(TaskB.class) + "TaskB.txt"))) {
            out.print(sb);
// second comment
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**
 * @param arg
 */
}
