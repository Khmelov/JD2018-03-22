package by.it.danilevich.jd02_06;

import by.it.danilevich.calc.ResourceManager;

import java.io.File;

public class Util {
    static ResourceManager rm;


    public static String getPath(Class<?> cl,String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }
    public static String getPathVarsTxt(){
        return getPath(Util.class, "vars.txt");
    }


    static String getPathBundle(Class<?> cl, String nameBundle){
        String path = System.getProperty("user.dir");
        path = cl.getName().replace(cl.getSimpleName(),"");
        path= path+ "ok." + nameBundle;

        return path;
    }

    public static String getError(String name){
        return rm.get(name);
    }


}
