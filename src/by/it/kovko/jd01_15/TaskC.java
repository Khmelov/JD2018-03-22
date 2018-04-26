package by.it.kovko.jd01_15;


import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;


public class TaskC {
    private static String path=TaskA.getPath(TaskC.class);
    public static void main(String[] args) {
        System.out.println("Вы находитесь в\n"+path);
        Scanner scanner = new Scanner(System.in);
        String str;
        while(!(str = scanner.nextLine()).equals("end")){
            if (str.equals("dir")){
                dir(path);
            } else if (str.startsWith("cd ") || str.startsWith("input:cd ")){
                cd(str.substring(3, str.length()));
                System.out.println(path);
            } else{
                System.out.println("Такой команды не существует");
            }
        }
    }
    private static void cd(String newPath){
        File newDir = new File (path+File.separator+newPath);
        if (newDir.exists()){
            try {
                path=newDir.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            File anotherDir = new File(newPath);
            if (anotherDir.exists()){
                try {
                    path=anotherDir.getCanonicalPath();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Директории не существует");
            }
        }
    }
    private static void dir (String path){
        File myDir = new File (path);
            if (myDir.exists()) {
                for (File file : myDir.listFiles()) {
                    String dirOrLen = "<DIR>";
                    if (file.isFile())
                        dirOrLen = String.valueOf((file.length()));
                    System.out.printf("%-25s %10s %-40s\n",
                            new Timestamp(file.lastModified()), dirOrLen, file.getName());
                }
        } else {
                System.out.println("Такой директории не существует\n");
            }
    }
}
