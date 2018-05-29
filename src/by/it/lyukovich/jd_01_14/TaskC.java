package by.it.lyukovich.jd_01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class TaskC {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Path currentDirectory = Paths.get(getPath(TaskC.class));
        Path fileWritePath = Paths.get(getPath(TaskC.class) + "resultTaskC.txt");
        //sb.append("Parent ");
        try (Stream<Path> filePathStream = Files.walk(currentDirectory.getParent())) {
            filePathStream.forEach(filePath -> {
                System.out.printf(pathInfo(filePath) + "\n");
                sb.append(pathInfo(filePath) + "\n");
            });
        }
        try {
            stringWriter(fileWritePath.toString(), sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    private static String pathInfo(Path path){
        try {

            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
            StringBuilder sb = new StringBuilder();
            if (attr.isDirectory()){sb.append("dir:").append(path.getFileName());}
            else {sb.append("file:").append(path.getFileName());}
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void stringWriter(String path, String string) throws IOException {
        BufferedWriter output = null;
        try {
            File file = new File(path);
            output = new BufferedWriter(new FileWriter(file));
            output.write(string);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
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
}
