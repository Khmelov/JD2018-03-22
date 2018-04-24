package by.it.kirova.jd01_14;

import java.io.*;
import java.util.ArrayList;

// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.lang.reflect.Array;
// import java.util.*;
// import java.util.stream.Stream;


public class TaskC {


    public static void main(String[] args) {
        String path = getPath(TaskC.class) + "..";
        String fout = getPath(TaskC.class, "resultTaskC.txt");
        File startDir = new File(path);

        try (PrintWriter pr = new PrintWriter(new FileWriter(fout))){
            ArrayList<String> messages = new ArrayList<>();
            initMessages(startDir, messages);
            for (String msg: messages) {
                pr.println(msg);
                System.out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

//        try (Stream<Path> paths = Files.walk(Paths.get(path)); PrintWriter pr = new PrintWriter(new FileWriter(fout))) {
//            paths.filter(Files::isRegularFile).forEach(x -> {
//                String msg = "dir:" + x.getParent().getFileName() + "\tfile:" + x.getFileName();
//                pr.println(msg);
//                System.out.println(msg);
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        private static void initMessages(File path, ArrayList<String> messages) throws IOException {
            if (path == null)
                return;
            if (path.isDirectory()) {
                messages.add("dir:" + path.getName());
                File[] inner =  path.listFiles();
                if (inner != null) {
                    for (File f: inner) {
                        initMessages(f, messages);
                    }
                }
            } else {
                messages.add("file:" + path.getName());
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
