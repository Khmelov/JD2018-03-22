package by.it.volchek.jd01_15;

import java.io.*;

/**
 * Created by volchek on 24.04.18.
 */
public class TaskA {
    public static void main(String[] args) {
        int[][] m = new int[6][4];
        String path = getPath (TaskA.class, "matrix.txt");
        try ( PrintWriter printer  = new PrintWriter (

                    new FileWriter(path)))
        {
            for (int[] ints : m) {
                for (int anInt : ints) {
                    anInt = (int) (Math.random() * 31 - 15);
                    printer.printf("%4d",anInt);
                }
                printer.println();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            int i;
            for (int[] ints : m) {
                String[] sarr = bufferedReader.readLine().trim().split("\\s+");
                for (String s : sarr) {
                    i = Integer.parseInt(s);
                    System.out.printf("%4d", i);
                }
                System.out.println();
            }
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
