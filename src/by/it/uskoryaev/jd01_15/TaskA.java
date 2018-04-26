package by.it.uskoryaev.jd01_15;

import java.io.*;

public class TaskA {
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName().
                replace(cl.getSimpleName(), "").
                replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }

    public static void main(String[] args) {
        int [] [] matrix = new int [6][4];
        String path = getPath(TaskA.class,"matrix.txt");

        try (PrintWriter printer = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++){
                    printer.printf("%3d ", (int) (-15 + Math.random() * 31));
            }
            printer.println();
        }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i <matrix.length; i++) {
                String [] sar = reader.readLine().trim().split("\\s+");
                for (int j = 0; j <matrix[i].length ; j++) {
                    matrix[i][j] = Integer.parseInt(sar[j]);
                    System.out.printf("%3d ",matrix[i][j]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
