package by.it.verishko.jd01_14;

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

    public static void main(String[] args) {
        String fn = getPath(TaskA.class, "dataTaskA.bin");
        String fout = getPath(TaskA.class, "resultTaskA.txt");
        System.out.println(fn);
        try (DataOutputStream ds = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fn)))) {
            for (int i = 0; i < 20; i++) {
                ds.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fn)));
             PrintWriter pr = new PrintWriter(
                     new FileWriter(fout))) {
            List<Integer> list = new ArrayList<>();
            double sum = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                list.add(i);
                sum += i;
            }
            for (Integer i : list) {
                System.out.print(i + " ");
                pr.print(i + " ");
            }
            System.out.println();
            pr.println();
            System.out.println("avg=" + sum / list.size());
            pr.print("avg=" + sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
