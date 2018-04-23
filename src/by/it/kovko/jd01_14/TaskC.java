package by.it.kovko.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    private static PrintWriter pr = null;
    private static String identation="";
    public static void main(String[] args) {
//        String path = System.getProperty("user.dir")
//                + "\\src\\by\\it\\kovko\\"
//                .replace("\\",File.separator);
        String path = TaskA.getPath(TaskC.class) + File.separator+"..";
        String fout = TaskA.getPath(TaskC.class, "resultTaskC.txt");
        try  {
            pr = new PrintWriter(new FileWriter(fout));
            pr.println("dir:..");
            System.out.println("dir:..");
            showDir(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (pr!=null)
                pr.close();
        }


    }
    private static void showDir(String path){
        identation+="\t";
        File myDir = new File(path);
        String dir[]=myDir.list();
        if (dir!=null) {
            for (String s : dir) {
                File newDir = new File(path + File.separator + s);
                if (newDir.isDirectory()) {
                    pr.println(identation+"dir:" + newDir.getName());
                    System.out.println(identation+"dir:" + newDir.getName());
                    showDir(newDir.getAbsolutePath());
                } else if (newDir.isFile()) {
                    pr.println(identation+"file:" + newDir.getName());
                    System.out.println(identation+"file:" + newDir.getName());
                }
            }
        }
        identation=identation.replaceFirst("\t","");
    }
}
