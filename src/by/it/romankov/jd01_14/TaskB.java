package by.it.romankov.jd01_14;
import java.io.*;
public class TaskB {
    private static String getPath(Class <?> cl) {

        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path;

    }

    private static String getPath(Class <?> cl, String filename) {
        return getPath(cl) + filename;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String res = getPath(TaskB.class, "resultTaskB.txt");
        String poem = getPath(TaskB.class, "text.txt");


        int i;
        try (BufferedReader bf = new BufferedReader(new FileReader(poem))) {
            String s;
            while ((s = bf.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = sb.toString();
        String sss = s.replaceAll("[-:!,.]", "").replaceAll("  ", " ");
        String[] ss = sss.trim().split(" ");
        System.out.println("words=" + ss.length);

        String pm = s.replaceAll("[а-яА-ЯЁё]", "").replaceAll(" ", "").replaceAll("\\n", "");
        String[] pmm = pm.split("");
        System.out.println("punctuation marks=" + pmm.length);

        try (PrintWriter pr = new PrintWriter(new FileWriter(res))) {
            pr.println("words=" + ss.length);
            pr.println("punctuation marks=" + pmm.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
