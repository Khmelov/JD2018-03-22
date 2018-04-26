package by.it.sgolovach.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskC {

    private static List<String> all = new ArrayList<>();

    private static void isDir(String path) {
        File dir = new File(path);
        if (dir.isFile()) {
            all.add("file:" + dir.getName());
        } else if (dir.isDirectory()) {
            all.add("dir:" + dir.getName());
            File[] file = dir.listFiles();
            if (file != null) {
                for (File f : file) {
                    isDir(f.getAbsolutePath());
                }
            }
        }
    }

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "sgolovach" + File.separator;
        all.add("dir:..");
        isDir(path);
        try (PrintWriter out = new PrintWriter(new FileWriter(dir(TaskC.class) + "resultTaskC.txt"))) {
            for (String str : all) {
                System.out.println(str);
                out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

