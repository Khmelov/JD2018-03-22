package by.it.kirova.jd01_15;

import java.io.*;

/**
 * @author K. Kirova, 2018
 */

public class TaskB {
    public static void main(String[] args) {
        /*
        Block/multi-line comment
         */
        StringBuilder sb = new StringBuilder();
        String pathRead = getPath(TaskB.class, "TaskB.java");
        String pathWriter = getPath(TaskB.class, "TaskB.txt");


        // try-catch block
        try (BufferedReader br = new BufferedReader(new FileReader(pathRead));
             PrintWriter pr = new PrintWriter(new FileWriter(pathWriter))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            removeComments("//", "\n", sb);
            //нижележащая строка неверно интерпретируется тестом как многострочный комментарий:
            removeComments("/*", "*/\n", sb);

            System.out.println(sb.toString());
            pr.println(sb.toString());
        } catch (
                IOException e)

        {
            e.printStackTrace();
        }

    }

    private static void removeComments(String startSybol, String endSymbol, StringBuilder sb){
        int startPosition = 0;
        do{
            int indexFirstSlash = sb.indexOf(startSybol, startPosition);
            if(indexFirstSlash == -1)
                break;
            if (sb.charAt(indexFirstSlash - 1) == '\"' || sb.charAt(indexFirstSlash + 2) == '\"') {
                startPosition = indexFirstSlash + 3;
            }
            else {
                int indexLastSlash = sb.indexOf(endSymbol, indexFirstSlash + 1);
                sb.delete(indexFirstSlash, indexLastSlash + endSymbol.length() - 1);
                startPosition = indexLastSlash + 1;
            }

        }
        while (startPosition <= sb.length());
    }

    // cross-platform getPath method
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    /*
    Block/multi-line comment
    */
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }
}
