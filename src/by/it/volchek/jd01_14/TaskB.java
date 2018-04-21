package by.it.volchek.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volchek on 21.04.18.
 */
public class TaskB {
    public static void main(String[] args) {
        String fn = getPath (TaskB.class,"TaskB.txt");
        String fout = getPath (TaskB.class,"ResultTaskB.txt");
        System.out.println(fn);
        String str = null;

      try (BufferedReader sr = new BufferedReader(new FileReader(fn))){
          StringBuffer sb =new StringBuffer();

          while (sr.readLine()!=null)
          {
              sb.append(sr.readLine());
          }
          str = sb.toString();

      } catch (IOException e) {
          e.printStackTrace();
      }
        String[] arrStr = str.split("[\\s?!.,:;-]+");
        String newStr = str.replaceAll("[\\s]+","");
        String[] arr = newStr.split("[А-Яа-яЁё]+");
        System.out.println("words="+arrStr.length+" punctuation marks="+arr.length);

        try (PrintWriter pr = new PrintWriter(new FileWriter(fout)))
        {
                pr.print("words="+arrStr.length+" punctuation marks="+arr.length);
        } catch (IOException e) {
            e.printStackTrace();
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
