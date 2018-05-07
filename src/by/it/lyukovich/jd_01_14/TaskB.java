package by.it.lyukovich.jd_01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String inpath = path (TaskB.class,"TaskB.txt");
        System.out.println(inpath);
        String str = null;
        try (BufferedReader br = new BufferedReader(new FileReader(inpath))){
            StringBuffer sb =new StringBuffer();
            for(String line = br.readLine(); line != null; line = br.readLine()){
                sb.append(line+"\n");
            }
            str = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrStr = str.split("[\\s?!\\n.,:;-]+");
        String newStr = str.replaceAll("[\\s]+","");
        String[] arr = newStr.split("[А-Яа-яЁё]+");
        System.out.println("words="+arrStr.length+", punctuation marks="+(arr.length-1));
        String outpath = path (TaskB.class,"ResultTaskB.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(outpath)))
        {
            pw.print("words="+arrStr.length+", punctuation marks="+(arr.length-1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String path(Class<?> cl, String filename) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator)+filename;
        return path;
    }
}
