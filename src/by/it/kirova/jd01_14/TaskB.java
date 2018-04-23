package by.it.kirova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    public static void main(String[] args) throws IOException {
        String fn = getPath(TaskB.class, "TaskB.txt");
        String fout = getPath(TaskB.class, "resultTaskB.txt");
        BufferedReader br = null;
        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))) {

            br = new BufferedReader(new FileReader(fn));
            StringBuilder sb = new StringBuilder();
            String line;
            int wordsCount = 0;
            int punctMarksCount = 0;
            Pattern w = Pattern.compile("[А-Яа-яЁё]+");
            Pattern p = Pattern.compile("[,;:.!?-]+");
            while ((line = br.readLine()) != null) {
                sb.append(line);

                Matcher mw = w.matcher(line);
                while (mw.find()) {
                    wordsCount++;
                }

                mw = p.matcher(line);
                while (mw.find()) {
                    punctMarksCount++;
                }
            }
            System.out.println("words=" + wordsCount);
            System.out.println("punctuation marks=" + punctMarksCount);
            pr.println("words=" + wordsCount);
            pr.println("punctuation marks=" + punctMarksCount);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }


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
}








//package by.it.kirova.jd01_14;
//
//import java.io.*;
//
//
//public class TaskB {
//    public static void main(String[] args) throws IOException {
//        String fn = getPath(TaskB.class, "TaskB.txt");
//        String fout = getPath(TaskB.class, "resultTaskB.txt");
//        BufferedReader br = null;
//        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))) {
//
//            br = new BufferedReader(new FileReader(fn));
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line).append(" ");
//            }
//
//
//            String str = sb.toString();
//            String str2 = sb.toString();
//
//
//            String[] wordsInStr = str.split("[\\s,;:.!?-]+");
//            int words = wordsInStr.length;
//            System.out.println("words=" + words);
//            pr.println("words=" + words);
//
//
//            str2 = str2.replaceAll("[\\s]+", "");
//            String[] punctInStr = str2.split("([.!?:,-]+)(?=[А-ЯЁа-яё]+)"); // избегаем троеточия
//            // логика: слово (пробелы уже отсутствуют), следом знак препинания (кол-во слов = кол-ву знаков препинания,
//            // исключение - предложения, начинающиеся со знака препинания и предложения содержащие кавычки)
//            // вариант 2 regex по словам "[А-Яа-яЁё]+, -1" - но! 1 лишний элемент добавится в начале массива:
//            // слева от букв за счет split, который делит по regex на левую и правую части (у нас левая отсутствует)
//            int punct = punctInStr.length;
//            System.out.println("punctuation marks=" + punct);
//            pr.print("punctuation marks=" + punct);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                br.close();
//            }
//        }
//    }
//
//    private static String getPath(Class<?> cl) {
//        String path = System.getProperty("user.dir");
//        path += File.separator + "src" + File.separator;
//        path += cl.getName()
//                .replace(cl.getSimpleName(), "")
//                .replace(".", File.separator);
//        return path;
//    }
//
//    private static String getPath(Class<?> cl, String filename) {
//        return getPath(cl) + filename;
//    }
//}
