package by.it.shvedov.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String src=System.getProperty("user dir")+"/src/by/it/shvedov";
        String fin=src+"/jd01_14/text/txt";
        try(FileInputStream is= new FileInputStream((new File(fin)))){
            int b=0;
            while((b=is.read())!=-1){
                System.out.println((char)b);
            }
        }  catch (IOException e) {
            System.out.println("ошибка файла"+e);
        }
    }

}