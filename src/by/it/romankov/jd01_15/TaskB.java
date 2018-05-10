package by.it.romankov.jd01_15;


import java.io.*;

public class TaskB {
    private static String getPath(Class <?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path;

    }

    private static String getPath(Class <?> cl, String filename) {
        return getPath(cl) + filename;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new FileWriter(getPath(TaskB.class, "TaskB.txt")));
        String s = null;
        boolean doc=false;
        int slash=0; int star=0; int count=0;
        try (BufferedReader br = new BufferedReader(new FileReader(getPath(TaskB.class, "TaskB.java")))) {
            while ((s = br.readLine()) != null) {
                char[] q = s.toCharArray();
                for ( char element: q) {
                    boolean one=false; boolean many=false;
                    if (element == '/') slash++;
                    if (element == '*') star++;
                    if (slash == 2) one = true;
                    if (slash == 1 && star == 1)
                        count++;
                    if (slash==1 && star==1 &&count==1) {
                        count = 0;
                    }
                    if (slash == 1 && star == 1 && count > 1) {
                        many = true;
                        count = 0;
                    }
                    if(!one && !many)
                        sb.append(s);
                    sb.append('\n');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        bw.write(sb.toString());
    }
}


//=========================
/*
 * kjdfnnn
 */


/**
 * @author Nikita
 */

