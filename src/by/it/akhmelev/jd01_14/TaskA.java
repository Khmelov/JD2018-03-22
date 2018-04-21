package by.it.akhmelev.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

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

//            FileOutputStream fs = new FileOutputStream(fn);
//            BufferedOutputStream bs = new BufferedOutputStream(fs);
//            DataOutputStream ds = new DataOutputStream(bs);


    public static void main(String[] args) {
        String fn = getPath(TaskA.class, "dataTaskA.bin");
        String fout = getPath(TaskA.class, "resultTaskA.txt");
        System.out.println(fn);
        //save
        try (DataOutputStream ds = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fn)))) {
            for (int i = 0; i < 20; i++) {
                ds.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //load
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fn)))
        ) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //print
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            System.out.println("avg=" + sum / list.size());
            pr.println("avg=" + sum / list.size());

            for (Integer i : list) {
                System.out.print(i + " ");
                pr.print(i + " ");
            }

            System.out.println();
            pr.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
