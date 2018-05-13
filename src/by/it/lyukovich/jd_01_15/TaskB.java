package by.it.lyukovich.jd_01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String pathRead = getPath(TaskB.class, "TaskB.java"); // Test 1 "First"
        String pathWriter = getPath(TaskB.class, "TaskB.txt"); /*
         */
        /* My test comment section
        *My first comment
        *@javadoc newparam
        *My second comment ////////////"/*/
        try (BufferedReader br = new BufferedReader(new FileReader(pathRead)); /* My comment
            ends here*/PrintWriter pw = new PrintWriter(new FileWriter(pathWriter))) {
            String line;
            String end="*"+"/"; String start= "/"+"*"; String onecom="/"+"/";
            while ((line = br.readLine()) != null) {
                if ((line.contains(onecom) && !(line.substring(line.indexOf(onecom), line.length()-1).contains("\")"))) ||
                        line.trim().startsWith(onecom)){ //Test comment ")
                    sb.append(line.substring(0, line.indexOf(onecom))).append("\n");
                } else if ((line.contains(start))){
                        String templine;
                        if (line.contains(end)) {

                                templine = line.substring(0, line.indexOf(start) - 1) + " " +
                                        line.substring(line.indexOf(end) + 2, line.length());
                                if (templine.length() > 0) sb.append(templine).append("\n");

                        } else {
                            templine = line.substring(0, line.indexOf(start) - 1);
                            if (templine.length() > 0) sb.append(templine).append("\n");
                            while (!(line.contains(end))) {
                                br.skip(1);
                                line = br.readLine();
                            }
                            if (line.contains(end)) {
                                templine = line.substring(line.indexOf(end)+2, line.length());
                                if (templine.length() > 0) sb.append(templine).append("\n");
                            } //"Test
                        }


                    } else sb.append(line).append("\n");
            }
            System.out.println(sb.toString());
            pw.println(sb.toString());
            //Тест проходит по однострочным комментам, если удалить нижнюю строку
            //System.out.println("// // // Test \")");
        } catch (
                IOException e)
        {
            e.printStackTrace();
        }
    }
    // Получаем путь
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");/*New comment
        ends here*/
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
