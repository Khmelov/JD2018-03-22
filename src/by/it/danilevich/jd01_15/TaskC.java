package by.it.danilevich.jd01_15;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskC {
    public static void main(String[] args) {
        String dirName = getPath(TaskC.class);
        //delete last catalog
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] catalog = dirName.split(pattern);
        String newPath = "";
        for (int i = 0; i < (catalog.length - 1); i++) {
            newPath = newPath + catalog[i] + File.separator;
        }
        dirName = newPath;
        System.out.println(dirName);
        Scanner sc=new Scanner(System.in);
        String command;
        while ((command=sc.nextLine())!="end"){
            if (command.equals("dir")){
                File f = new File(dirName);
                listFilesForFolder(f);
            }

        }
    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }
    private static void listFilesForFolder(File folder) {

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                //fileEntry.
                System.out.println("dir:" + fileEntry.getName());
                //forFiles.add("dir:" + fileEntry.getName());
               // listFilesForFolder(fileEntry, forFiles);
            } else {
                System.out.println("file:" + fileEntry.getName());
                //forFiles.add("file:" + fileEntry.getName());
            }
        }
      //  return forFiles;
    }

}
