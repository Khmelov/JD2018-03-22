package by.it.kovko.jd01_14;

import by.it._examples_.jd01_14.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String f = getPath(TaskA.class, "DataTaskA.bin");
        String fout = getPath(TaskA.class, "resultTaskA.txt");
        System.out.println(f);
        try (DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)))){
            for (int i = 0; i < 20; i++) {
                ds.writeInt((int)(Math.random()*100+1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        double sum=0;
        try (DataInputStream dis = new DataInputStream((new BufferedInputStream(new FileInputStream(f))))){
            while (dis.available()>0){
                int i=dis.readInt();
                list.add(i);
                sum+=i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("avg=" + sum / list.size()+"\n");
        System.out.println(list.toString().replaceAll("[^0-9]+"," "));
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))){
            pr.print("avg=" + sum / list.size()+"\n");
            pr.print(list.toString().replaceAll("[^0-9]+"," "));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }
    static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path+=(File.separator+"src"+File.separator);
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;
    }
}
