package by.it.volchek.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volchek on 21.04.18.
 */
public class TaskC {
     static String fout = getPath (TaskC.class,"ResultTaskC.txt");
    static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"by"+File.separator+"it"+File.separator+"volchek"+File.separator;
       dirWatcher(path);
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout)))
        {
            for (String s : fileList) {
                pr.print(s+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
     static void dirWatcher(String path){
         File file = new File(path);
         File[] str = file.listFiles();
         for (File s : str) {
             if (s.isDirectory())
             {
                 System.out.println("dir:"+s.getName());
             fileList.add("dir:"+s.getName());
             }
             else {
                 if (s.getName().charAt(0)=='.') continue;
                 System.out.println("file:"+s.getName().substring(0,s.getName().lastIndexOf(".")));
                 fileList.add("file:"+s.getName().substring(0,s.getName().lastIndexOf(".")));
             }
             if (s.isDirectory()) dirWatcher(s.getAbsolutePath());
         }
     }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;

    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;

    }
}




