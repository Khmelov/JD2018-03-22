package by.it.danilevich.jd01_14;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TaskC {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += TaskC.class.getName().replace(TaskC.class.getSimpleName(), "").replace(".", File.separator);
        System.out.println(path);
        //delete last catalog
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] catalog = path.split(pattern);
        String newPath = "";
        for (int i = 0; i < (catalog.length - 1); i++) {
            newPath = newPath + catalog[i] + File.separator;
        }
        FileWriter f = new FileWriter(getPath(TaskA.class,"resultTaskC.txt"));
        PrintWriter pr = new PrintWriter(f);

        File folder = new File(newPath);
        List<String> forFiles = new ArrayList<>();
        List<String> RezFiles = listFilesForFolder(folder, forFiles);
        for (String str:RezFiles) {
            pr.println(str);
        }
        pr.close();
    }

    private static List<String> listFilesForFolder(File folder, List<String> forFiles) {

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                System.out.println("dir:" + fileEntry.getName());
                forFiles.add("dir:" + fileEntry.getName());
                listFilesForFolder(fileEntry, forFiles);
            } else {
                System.out.println("file:" + fileEntry.getName());
                forFiles.add("file:" + fileEntry.getName());
            }
        }
        return forFiles;
    }

    private static String getPath(Class<?> cl,String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }

}
