package by.it.danilevich.jd01_15;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TaskB {
    /**
     * Функция получает каталог, где хранится заданный класс
     *
     * @param cl - класс
     * @return - строка каталога
     */
    private static String getPath(Class<?> cl) {//zxdcftvgbhunmes
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
    public static void RandomNumberSaveToFile() {
        int[][] m = new int[6][4];
        String path = getPath(TaskB.class, "matrix.txt");
        try (PrintWriter printer = new PrintWriter(
                new FileWriter(path))
        ) {
            /*генерация чисел
              в промежутке от -15 до 15
             */

            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    printer.printf("%3d ", (int) (-15 + Math.random() * 31));
                }
                printer.println();
            }
            /*
            обработка исключения
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(path))
        ) {//заносим полученные данные в файл
            for (int i = 0; i < m.length; i++) {
                String[] sarr = bufferedReader.readLine().trim().split("\\s+");
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = Integer.parseInt(sarr[j]);
                    System.out.printf("%3d ",m[i][j]);
                }
                System.out.println();
            }
            //обработка исключения
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //главная функция
    public static void main(String[] args) throws FileNotFoundException {
        String dirName = getPath(TaskB.class);//проба проба
        try (FileReader fileReader = new FileReader(dirName+File.separator+TaskB.class.getSimpleName()+".java")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> programLine = new ArrayList<>();
            String s = "";
            String stringCheck = "";
            //int numstr = 0;
            boolean beginComment = false;
            while ((s = bufferedReader.readLine()) != null) {
                //  numstr = numstr+1;
                // if (numstr <80) continue;
                boolean addString = true;
                stringCheck = s.trim();
                int find = stringCheck.indexOf("/".concat("/"));
                int find2 = stringCheck.indexOf("/".concat("*"));
                int find3 = stringCheck.indexOf("*".concat("/"));
                if (beginComment==true&&find3==-1) continue;
                if (find3!=-1){
                    beginComment = false;
                    continue;
                }
                if (find2 != -1) {
                   beginComment =true;
                } else {
                    if ( find == 0){
                        addString = false;
                    }
                    else if (find != -1){
                        if (stringCheck.indexOf("\"",find-1)!=(find-1)){//проверяем строку в коде на проверку самого комментарий
                            String subString = stringCheck.substring(find);
                            s = s.replaceAll(subString,"");
                        }
                        else {
                            find = stringCheck.indexOf("/".concat("/"),find+4);
                            if (find != -1) {
                                String subString = stringCheck.substring(find);
                                s = s.replaceAll(subString,"");
                            }
                        }
                    }
                    if (addString == true) {
                        programLine.add(s);
                       // System.out.println(s);
                    }
                }
            }
            writeListToFile(programLine);
            readFromFile(getPath(TaskB.class, "TaskB.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeListToFile(List<String> list) throws IOException {
        String path = getPath(TaskB.class, "TaskB.txt");
        FileWriter fileReader = new FileWriter(new File(path));
        PrintWriter printWriter = new PrintWriter(fileReader);
        for (String line:list){
            printWriter.println(line);
        }
        fileReader.close();
    }
    private static void readFromFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            sb.append( s + "\n");
            System.out.println(s);
        }
        scanner.close();
    }
}