package by.it.lyukovich.jd_01_14;

import java.io.*;

public class TaskA {

    private static String dir(Class<?> cl){
        String path = System.getProperty("user.dir")+ File.separator+ "src"+ File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path + classDir;
    }

    public static void main(String[] args) throws IOException {
        DataOutputStream dos = null;
        try{
            dos = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*25));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dos != null){
                dos.close();
            }
        }
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
            PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))){
            double sum = 0, count = 0;
            while (in.available()>0){
                int i = in.readInt();
                System.out.print(i + " ");
                sum+=i;
                count++;
            }
            System.out.println("\navg="+sum/count);
                }

    }
}
