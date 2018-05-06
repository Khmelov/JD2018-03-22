package by.it.poprugo.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alena V. Papruha
 */
public class TaskB {

    /*
    get the Path to the work directory
     */
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir"); //корень JD018...
        path += File.separator + "src" + File.separator; //чтобы слэш - соответствовал системе
        path += cl.getName() //work directory
                .replace(cl.getSimpleName(), "") // TaskA = cl.getSimpleName()
                .replace(".", File.separator); //заменили точки на правильные (для нашей с-мы) слэши
        return path;
    }

    /*
    add file Name to the work directory
     */
    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }

    public static void main(String[] args) throws IOException {
        String fileName = getPath(TaskB.class, "TaskB.java");
        System.out.println(fileName);
//        String fout = getPath(TaskA.class, "resultTaskB.txt");
//        PrintWriter pr = new PrintWriter(
//                new FileWriter(fout)
//        );

        //объявим коллекцию строк, со своим вариантом преобразования в строку
        List<String> txtLn=new ArrayList<String>(){
            @Override //вспомогательный анонимный класс,
            //для вывода коллекции в нужном нам формате
            //добавлено для повторения этого материала
            public String toString() {
                int n=0;
                StringBuilder out = new StringBuilder();
                for (String s:this) {
                    out.append(n).append("\n"); n++;}
                return out.toString();
            }
        };

        //Пример 1.
        //чтение текстового файла в подготовленную выше коллекцию
        try (BufferedReader bufferedReader=
                     new BufferedReader(
                             new FileReader(fileName))){
            Pattern pOne = Pattern.compile("(//)");

            String line;
            //System.out.println("1. line:\n"+line);
            //пока линия читается, присвоим ее и тут же сравним с null
            while ((line = bufferedReader.readLine())!=null)
                    txtLn.add(line.replaceAll("(//).*", ""));
                    //txtLn.add(line); //линия прочиталась. Добавим ее в коллекцию


            System.out.println("2. line:\n"+line);
            System.out.println("3. txtLn:\n"+txtLn.size());
            for (String s : txtLn) {
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new IOException("Not read "+fileName,e);
        }




        /*File fileText = new File(fileName);
        FileReader exist = null;
        int b;
        String string = "";
        try {
            exist = new FileReader(fileText);
            while ((b = exist.read()) != -1) {
                string += (char) b; //all the text - in the only string
            }
            int countW=0, countS=0;
            // "[а-яА-ЯёЁ]+" - pattern to all Russian words
            Pattern pOne = Pattern.compile("(//)");
            Matcher matchW = pOne.matcher(string); //"беать" по string
            while (matchW.find()) countW++;
            System.out.println("+++"+countW);
            Pattern pEnd = Pattern.compile("(\\n)");
            Matcher matchS = pEnd.matcher(string); //"беать" по string
            while (matchW.find()) countS++;
            System.out.println("\\"+countS);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}