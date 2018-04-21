package by.it.desykevich.jd01_14;

import java.io.File;
import java.lang.reflect.Field;

public class TaskA {

    private static String getPath(Class<?> cl) {
        String path=System.getProperty("user.dir");
        path+= File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace('.',File.separatorChar);
        return path;
    }

    private static String getPath(Class<?> cl,String filename) {
        return  getPath(cl)+filename;
    }

    public static void main(String[] args) {
        String path=getPath(TaskA.class);
        System.out.println(path);
    }
}
