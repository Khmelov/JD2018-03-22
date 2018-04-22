package by.it.shvedov.jd01_14;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        String fn=getPath(TaskA.class,"dataTaskA.bin");
        System.out.println(fn);
        //FileOutputStream
        DataOutputStream ds=null;
        try{
            ds = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fn)));
            for (int i = 0; i <20 ; i++) {
                ds.writeInt((int)(Math.random()*1000));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try(DataInputStream ds= new DataInputStream(new BufferedInputStream(new FileInputStream(fn))){
                 double sum=0;
                 double count =0;
                 while(ds.available()>0)

        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(ds !=null) {
                try {
                    ds.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }
    private static String getPath(Class<?> cl) {
        String path=System.getProperty("user.dir");
        path+=File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;
    }

}
