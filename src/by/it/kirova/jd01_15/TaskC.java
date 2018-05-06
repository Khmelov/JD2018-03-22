package by.it.kirova.jd01_15;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.stream.Stream;

class DirCommandExtraInfo{
    private int filesCount = 0;
    private int directoriesCount = 0;
    private long filesSize = 0;

    void appendFileSize(long s){
        filesSize += s;
        filesCount++;
    }

    void appendDirectory(){
        directoriesCount ++;
    }

    void print(){
        System.out.println(filesCount + " файлов" + "\t" + filesSize + " байт");
        System.out.println(directoriesCount + " папок");
    }
}

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Path currentDirectory = Paths.get(getPath(TaskC.class));
        while (true) {
            System.out.print(currentDirectory + ">");

            String line = scanner.nextLine();
            if(line.startsWith("cd")) {
                Path arguments = Paths.get(line.substring(2).trim());
                arguments = processPath(currentDirectory, arguments);
                if(arguments != null)
                    currentDirectory = arguments;
            } else if(line.startsWith("dir")){
                Path arguments = Paths.get(line.substring(3).trim());
                arguments = processPath(currentDirectory, arguments);
                if(arguments != null)
                    invokeDirCommand(arguments);
            } else if(line.startsWith("end")){
                break;
            } else {
                System.out.println('"' + line + "\" не является внутренней или внешней " +
                        "командой, исполняемой программой или пакетным файлом.");
            }
        }


    }

    private static Path processPath(Path currentDirectory, Path arguments){

        if(arguments.isAbsolute()){
            if(Files.isDirectory(arguments)){
                return arguments;
            }
            else {
                System.out.println("Неверно задано имя папки.");
                return null;
            }
        }
        else {
            Path newDir = currentDirectory.resolve(arguments);
            if(Files.isDirectory(newDir)){
                return newDir.normalize();
            }
            else {
                System.out.println("Неверно задано имя папки.");
                return null;
            }

        }
    }


    private static  void invokeDirCommand(Path path){
        DirCommandExtraInfo info = new DirCommandExtraInfo();
        System.out.println("Содержимое папки " + path.toAbsolutePath());
        printPathInfo(path, ".", info);
        printPathInfo(path.getParent(), "..", info);
        try (Stream<Path> paths = Files.walk(path, 1)){
            paths.skip(1).forEach(x -> printPathInfo(x, x.getFileName().toString(), info));
            info.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPathInfo(Path path, String pathName, DirCommandExtraInfo info) {
        if(path == null)
            return;

        try {
            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            String dateCreated = df.format(attr.creationTime().toMillis());

            String subInfo;
            if(Files.isDirectory(path)){
                subInfo = "<DIR>       ";
                info.appendDirectory();
            }else {
                Long fs = attr.size();
                subInfo = String.format("%12d", fs);
                info.appendFileSize(fs);
            }

            String msg = dateCreated +"\t" + subInfo + "\t" + pathName;
            System.out.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
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
