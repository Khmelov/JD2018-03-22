//package by.it.uskoryaev.jd01_15;
//
//import java.io.*;
//
//public class TaskA {
//    public static void main(String[] args) {
//        int [] [] matrix = new int [6][4];
//        String path = getPath(TaskA.class,"matrix.txt");
//
//        try (PrintWriter printer = new PrintWriter(new FileWriter(path))){
//            for (int i = 0; i <matrix.length ; i++) {
//                for (int j = 0; j <matrix[i].length ; j++)
//                    printer.printf("3%d", (int)(-15+Math.random()*15+31));
//            }
//            printer.println();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            for (int i = 0; i <matrix.length; i++) {
//                String [] sar = reader.
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    private static String getPaht(Class<?> cl) {
//        String path = System.getProperty("user.dir");
//        path += File.separator + "src" + File.separator;
//        path += cl.getName().
//                replace(cl.getSimpleName(), "").
//                replace(".", File.separator);
//        return path;
//    }
//
//    private static String getPath(Class<?> cl, String fileName) {
//        return getPaht(cl) + fileName;
//    }
//}
