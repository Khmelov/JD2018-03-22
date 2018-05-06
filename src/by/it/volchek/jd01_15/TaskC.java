package by.it.volchek.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by volchek on 25.04.18.
 */
public class TaskC {

    static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"by"+File.separator+"it"+File.separator+"volchek"+File.separator;
        File file = new File(path);
        String command;
        String subCommand;
        Scanner scanner=new Scanner(System.in);
        System.out.println(file);
        while (!(command = scanner.nextLine()).equals("end")){
            command=command.trim();
           if (command.equals("dir")) dirWatcher(file);
            try {
                if (command.substring(0, 2).equals("cd")) {
                    subCommand = command.substring(2, command.length());
                    subCommand = subCommand.trim();
                    if (subCommand.equals("..")) {
                        try {
                            file = new File(file.getParent());
                            System.out.println(file);
                            continue;
                        } catch (NullPointerException e) {
                            System.out.println("Достигнута корневая директория. Операция невозможна");
                        }
                    }
                    if (dirFinder(file, subCommand)!=null) {
                        path =file.getPath()+File.separator+subCommand+File.separator;
                        System.out.println(path);
                        file = new File(path);

                        continue;
                    }


                }


            }

        catch (StringIndexOutOfBoundsException e){
            System.out.println("");
        }
        }



    }
    static String dirFinder(File file, String name){
        File[] str = file.listFiles();

        for (File s : str) {
            if ((s.isDirectory())&&(s.getName().equals(name)))

                return name;
            }
            return null;
    }
    static void dirWatcher(File file){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        File[] str = file.listFiles();
        long dirSize=0, filesSize=0;
        int dirCount=0, filesCount = 0;

        for (File s : str) {
            if (s.isDirectory())
            {
                dirCount++;
                dirSize+=folderSize(s);
                System.out.println(sdf.format(s.lastModified())+"\t\t<DIR>\t\t"+s.getName());
               // fileList.add("dir:"+s.getName());
            }
            else {


                filesCount++;
                filesSize+=s.length();
                System.out.println(sdf.format(s.lastModified())+"\t\t\t\t"+s.getName());
                //fileList.add("file:"+s.getName());
            }
          //  if (s.isDirectory()) dirWatcher(s.getAbsolutePath());
        }
        System.out.println("Всего папок: "+dirCount+" Занято места: "+dirSize);
        System.out.println("Всего файлов: "+filesCount+" Занято места: "+filesSize);


    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles())
        {
            if (file.isFile()) length += file.length();
            else length += folderSize(file);
        }
        return length;
    }


}
