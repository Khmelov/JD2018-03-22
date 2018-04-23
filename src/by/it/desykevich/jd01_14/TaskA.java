package by.it.desykevich.jd01_14;

import java.io.*;
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
        String fn=getPath(TaskA.class,"dataTaskA:");
        System.out.println(fn);

        try (DataOutputStream ds=
             new DataOutputStream((
                 new BufferedOutputStream(
                 new FileOutputStream(fn))));
            )

        {
            for (int i = 0; i <20; i++) {
                ds.writeInt((int)(Math.random()*100));
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
         }
         catch (IOException e) {
            e.printStackTrace();
        }

    }
}
