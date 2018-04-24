package by.it.poprugo.jd01_14;

import by.it.kirova.calc.Printer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String getPath(Class<?> cl) { //cl - ? taskAClass
        String path = System.getProperty("user.dir"); //корень JD018...
        path += File.separator + "src" + File.separator; //чтобы слэш - соответствовал системе
        path += cl.getName() //by.it.poprugo.jd01_14.TaskA
                .replace(cl.getSimpleName(), "") // TaskA = cl.getSimpleName()
                .replace(".", File.separator); //заменили точки на правильные (для нашей с-мы) слэши
        return path;
    }

    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }

    public static void main(String[] args) {
        //String path = getPath(TaskA.class);
        //System.out.println(path);
        String fn = getPath(TaskA.class, "dataTaskA.bin");
        String fout = getPath(TaskA.class, "resultTaskA.txt");
        //String fn = "D:\\IT\\JD_2018\\JD2018-03-22\\src\\by\\it\\poprugo\\jd01_14"; через copy-paste
        System.out.println(fn);
        //DataOutputStream ds=null; - - без(!) try с параметрами/ресурсами
        try (DataOutputStream ds =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(fn)))) {
            for (int i = 0; i < 20; i++) {
                ds.writeInt((int) (Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally { - без(!) try с параметрами/ресурсами
//            if (ds !=null) {
//                try {
//                      dos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        try (DataInputStream dis =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(fn)));
             PrintWriter pr = new PrintWriter(
                     new FileWriter(fout)
             );
        ) {
            List<Integer> list = new ArrayList<>();
            double sum = 0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                list.add(i);
                sum+=i;
            }
            System.out.print("list" + list);
            System.out.println("\navg="+sum/list.size());
            pr.println("avg="+sum/list.size());
            for (Integer i : list) {
                System.out.print(i+" ");
                pr.print(i + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
