// hello
// this is simple comment
    /*
    other comment
     */
    /*
    other comment number two
     */
/**
 * omg JavaDoc
 */

package by.it.desykevich.jd01_15;


import java.io.*;



public class TaskB {
    private static StringBuilder sb = new StringBuilder();
    private static boolean complexDelete = false;

    public static void main(String[] args) {
        File input = new File(getRoot(), "TaskB.java");
        File output = new File(getRoot(), "TaskB.txt");
        readFile(input);
        System.out.println(sb);
        writeFile(output);


    }

    private static String getRoot() {
        return System.getProperty("user.dir") +
                File.separator +
                "src" +
                File.separator +
                TaskB.class.getName()
                        .replace(TaskB.class.getSimpleName(), "")
                        .replace(".", File.separator);
    }

    private static void readFile(File file) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(file))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(delete(line + "\n"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String delete(String line) {
        if (complexDelete) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '*') {
                    if (line.charAt(i + 1) == '/') {
                        complexDelete = false;
                        return line.substring(i + 3);
                    }
                }
            }
            return "";
        }
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '/') {
                if (line.charAt(i + 1) == '/') {
                    return line.substring(0, i);
                }
                if (line.charAt(i + 1) == '*' && line.charAt(i + 2) != '*') {
                    complexDelete = true;
                    return line.substring(i + 3);
                }
                if (line.charAt(i + 1) == '*' && line.charAt(i + 2) == '*') {
                    complexDelete = true;
                    return line.substring(i + 4);
                }
            }
        }
        return line;
    }

    private static void writeFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)
        ) {
            writer.printf(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

