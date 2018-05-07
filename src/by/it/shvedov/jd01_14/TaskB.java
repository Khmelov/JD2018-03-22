package by.it.shvedov.jd01_14;

import java.io.*;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class TaskB {
    public static void main(String[] args) throws IOException {
        try {
            FileReader f = new FileReader(getPath(TaskB.class,"text.txt"));
            BufferedReader buf = new BufferedReader(f);
            String line;
            List<String> list= new ArrayList<>();
            while ((line = buf.readLine())!=null){
                list.add(line);
            }
            int countWord = 0;
            int coutMarks= 0;
            Pattern p = Pattern.compile("[-,.!?:;]+");//(",.!?-:;");

            for (String l:list) {
                Matcher matcher = p.matcher(l);
                while (matcher.find()){
                    coutMarks = coutMarks +1;
                }

                countWord = countWord + l.replaceAll("[,.!?:;][ ]{2}]","").replaceAll("- ","").split(" ").length;

            }
            System.out.println("words=" + countWord + ", punctuation marks=" + coutMarks);
            FileWriter fileWriter = new FileWriter(getPath(TaskB.class,"resultTaskB.txt"));
            PrintWriter pr = new PrintWriter(fileWriter);
            pr.print("words=" + countWord + ", punctuation marks=" + coutMarks);
            f.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String getPath(Class<?> cl,String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }
}
