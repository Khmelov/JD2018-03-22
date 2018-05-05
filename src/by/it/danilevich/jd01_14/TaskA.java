package by.it.danilevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String path = getPath(TaskA.class,"dataTaskA.bin");
         //Scanner sc=new Scanner(System.in);
        System.out.println(path);
        try(DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))){
            for (int i = 0; i < 20; i++) {
                int num = (int)(Math.random()*100);
                ds.writeInt(num);
               // System.out.println(num);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

         try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))){
             List<Integer> list= new ArrayList<>();
             FileWriter f = new FileWriter(getPath(TaskA.class,"resultTaskA.txt"));
             PrintWriter pr = new PrintWriter(f);
             double sum =0;
             while (dis.available()>0){
                 int i = dis.readInt();
                 list.add(i);
                 System.out.print(i + " ");
                 pr.print(i + " ");
                 sum = sum + i;
             }
             double arg =0;
             if(list.size()>0) {
                  arg = sum/list.size();
             }
             System.out.print("avg=" + arg);

             pr.print("avg="+ arg);
             f.close();
         }
    }

    private static String getPath(Class<?> cl,String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }
}
