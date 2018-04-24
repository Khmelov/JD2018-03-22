package by.it.poprugo.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskB {

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator; //чтобы слэш - соответствовал системе
        path += cl.getName() //by.it.poprugo.jd01_14.TaskA
                .replace(cl.getSimpleName(), "") // TaskA = cl.getSimpleName()
                .replace(".", File.separator); //заменили точки на правильные (для нашей с-мы) слэши
        return path;
    }

    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        /*String pathB = */
        getPath(TaskB.class);
        String fName = getPath(TaskB.class, "text.txt");
        System.out.println(fName);

        List<String> arr = new ArrayList<>();

        File text = new File(fName);
        /*Scanner scanner = new Scanner(text);
        scanner.useDelimiter("[ *\n]");*/ // delimiter is space or \n
        FileReader exist = null;
        int b;
        String string = "";
        try {
            exist = new FileReader(text);
            while ((b = exist.read()) != -1) {
                string += (char) b;
            }
            //System.out.println("string:\n" + string);
            arr = Arrays.asList(string);

            System.out.println();
            for (String s : arr) {
                System.out.print(s + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (exist != null)
                    exist.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*try (BufferedReader br = new BufferedReader(
                new FileReader(getPath(TaskB.class, "text.txt")))) {
            int b;
            FileReader exist = null;
            List<String> arr = new ArrayList<>();
            while ((b = exist.read()) != -1)
                System.out.println(br);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
