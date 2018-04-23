package by.it.desykevich.jd01_14;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

import static by.it.desykevich.jd01_14.Test_jd01_14.dir;

public class TaskA {

    private static String getPath(Class<?> cl) {
        String path=System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        String clDir =cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }


    public static void main(String[] args) {
        DataOutputStream dos= null;

        try {
            dos=new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin"))
            );
            for (int i=0 ; i<20;i++){
                dos.writeInt((int)(Math.random()*25));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (dos !=null){
                try {
                    dos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))

        ){
            double sum=0;
            double count=0;
            while (inp.available()>0){
                int i=inp.readInt();
                System.out.print(i+" ");
                out2.print(i+" ");
                sum+=i;
                count++;
            }
            System.out.println("\navg="+sum/count);
            out2.print("\navg="+sum/count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    private static String getPath(Class<?> cl,String filename) {
//        return  getPath(cl)+filename;
//    }
//
//    public static void main(String[] args) {
//        String fn=getPath(TaskA.class,"dataTaskA:");
//        String fout = getPath(TaskA.class, "resultTaskA.txt");
//        System.out.println(fn);
//
//        try (DataOutputStream ds = new DataOutputStream(
//                 new BufferedOutputStream(
//                        new FileOutputStream(fn)))) {
//            for (int i = 0; i <20; i++) {
//                ds.writeInt((int)(Math.random()*100));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<Integer> list = new ArrayList<>();
//        try (DataInputStream dis = new DataInputStream(
//                new BufferedInputStream(
//                        new FileInputStream(fn)))
//        ){
//            while (dis.available()>0){
//                list.add(dis.readInt());
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        try(PrintWriter pr= new PrintWriter(new FileWriter(fout))) {
//            int sum = 0;
//            for (Integer i :list){
//                sum+=i;
//            }
//            System.out.println("avg="+ sum / list.size());
//            pr.println("avg="+sum / list.size());
//
//            for (Integer i : list){
//                System.out.print(i+" ");
//                pr.print(i+" ");
//            }
//
//            System.out.println();
//            pr.println();
//
//
//            } catch (IOException e){
//            e.printStackTrace();
//
//        }
//    }
}
