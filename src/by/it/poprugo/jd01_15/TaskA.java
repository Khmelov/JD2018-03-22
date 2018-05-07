package by.it.poprugo.jd01_15;

import java.io.*;

public class TaskA {

//getPath
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
        int[][] m = new int[6][4];
        String path = getPath(TaskA.class, "matrix.txt");

        try (PrintWriter printer = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = (int) (-15 + Math.random() * 31);
                    printer.printf("%3d ", m[i][j]);
                }
                printer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < m.length; i++) {
                String[] sarr = bufferedReader.readLine().trim().split("\\s+");
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = Integer.parseInt(sarr[j]);
                    System.out.printf("%3d ", m[i][j]);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
