package by.it.lyukovich.jd_01_15;
import java.io.*;
import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class TaskC {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Path currentDirectory = Paths.get(getPath(TaskC.class));
        System.out.print(currentDirectory + " \n");
        String line="";
        while (!(line.equalsIgnoreCase("end"))) {

            line = sc.nextLine();

            if (line.startsWith("cd")) {
                Path path;
                if (line.contains("cd ..")){
                    path = currentDirectory.getParent();
                }else if (Files.exists(Paths.get(line.substring(2).trim()))) {
                    path = Paths.get(line.substring(2).trim());
                    currentDirectory = path;
                }else

                    path =Paths.get((currentDirectory.toString()+"/"+line.substring(2).trim()));
                    currentDirectory = path;
                    System.out.println(path);
                    if (!Files.exists(path)) System.out.println("Такой директории не существует");


            } else if (line.startsWith("dir")) {
                Path path;
                if (line.substring(3).length()>0)
                path = Paths.get(line.substring(3).trim()+"/"); else path = Paths.get(currentDirectory+"/");
                AtomicInteger filesCount= new AtomicInteger(); AtomicInteger dirCount= new AtomicInteger(); AtomicLong fileSize= new AtomicLong();
                if (Files.exists(path)) {

                    try (Stream<Path> filePathStream=Files.walk(path,1)) {
                        filePathStream.forEach(filePath -> {
                            System.out.printf(pathInfo(filePath) + "\n");
                            if (Files.isDirectory(filePath)) dirCount.getAndIncrement(); else filesCount.getAndIncrement();
                            try {
                                fileSize.addAndGet(Files.size(filePath));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                    }
                    System.out.println("Всего папок: "+dirCount);
                    System.out.println("Всего файлов: "+filesCount+" Занято места: "+fileSize);
                } else System.out.println("Такой директории не существует");
            }
        }
    }
private static String pathInfo(Path path){
    try {
        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        StringBuilder sb = new StringBuilder();
        String dir; if (attr.isDirectory()) {dir="<DIR>";} else dir="\t";
        if (attr.isDirectory()){sb.append(datef.format(attr.creationTime().toMillis())).append("\t\t").append(dir).
                append("\t\t").append("\t\t\t").append(path.getFileName());}
        else sb.append(datef.format(attr.creationTime().toMillis())).append("\t\t").append(dir).append("\t").
                append(attr.size()).append("\t\t").append(path.getFileName());
        return sb.toString();
        } catch (IOException e) {
        e.printStackTrace();
        return null;
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