package by.it.verishko.jd01_15;

import java.io.*;

public class TaskB {
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

    public static void main(String[] args) {

//        Первый однострочный комментарий
//        Второй однострочный комментарий
        /*        Третий комментарий (многострочный)         */
        /*        Четвертый комментарий (многострочный)      */
/**       JavaDoc комментарий                        */

        StringBuilder sb = new StringBuilder();
        String fn = getPath(by.it.verishko.jd01_15.TaskB.class);
        String path = getPath(TaskB.class, "TaskB.txt");
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
            while ((line = br.readLine()) != null) sb.append(line).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        int startIndex, endIndex;
        while ((startIndex = sb.indexOf("\u002f*")) >= 0 && (endIndex = sb.indexOf("*\u002f")) >= 0) {
            sb.delete(startIndex, endIndex + 2);
        }
        while ((startIndex = sb.indexOf("\u002f/")) >= 0 && (endIndex = sb.indexOf("\n", startIndex)) >= 0) {
            sb.delete(startIndex, endIndex);
        }
        try (PrintWriter printer = new PrintWriter(new FileWriter(path))) {
            printer.print(sb);
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
