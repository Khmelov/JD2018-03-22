package by.it.uskoryaev.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) {
        String fnn = getPath(TaskA.class,"dataTaskA.bin");
        String fount = getPath(TaskA.class,"resultTaskA.txt");
        System.out.println(fnn);

        try(DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fnn)))){
            for (int i = 0; i <20; i++) {
                ds.writeInt((int)(Math.random()*100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream dv = new DataInputStream(new BufferedInputStream(new FileInputStream(fnn)));
             PrintWriter pr = new PrintWriter(new FileWriter(fount))){
            //load
            List<Integer>list = new ArrayList<>();
            double sum = 0;
            while (dv.available()>0){
                int i = dv.readInt();
                list.add(i);
                sum+= i;
            }
            System.out.println("avg = "+sum/list.size());
            pr.print("avg = "+sum/list.size());
            for (Integer i:list) {
                System.out.print(i + " ");
                pr.print(i+" ");
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    private static String getPaht(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator+"src"+File.separator;
        path += cl.getName().
                replace(cl.getSimpleName(),"").
                replace(".",File.separator);
        return path;
    }

    private static String getPath(Class<?> cl,String fileName){
        return getPaht(cl)+fileName;
    }

}
