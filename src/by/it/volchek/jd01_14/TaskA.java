package by.it.volchek.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volchek on 21.04.18.
 */
public class TaskA {
    public static void main(String[] args) {
        String fn = getPath (TaskA.class,"DataTaskA.bin");
        String fout = getPath (TaskA.class,"ResultTaskA.txt");
        System.out.println(fn);

        try (DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fn))))
        {
            for (int i = 0; i <20 ; i++) {
                ds.writeInt((int)(Math.random()*100));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fn)));PrintWriter pr = new PrintWriter(new FileWriter(fout)))
        {
            List<Integer> list = new ArrayList<>();
            double sum =0;
            while (dis.available()>0){
                int i=dis.readInt();
               list.add (i);
                sum+=i;
            }
            for (Integer integer : list) {
                System.out.print(integer+" ");
                pr.print(integer+" ");
            }
            System.out.println();
            pr.println();
            System.out.println("avg="+sum/list.size());
            pr.print("avg="+sum/list.size());

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
