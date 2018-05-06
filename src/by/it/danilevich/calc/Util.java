package by.it.danilevich.calc;

import java.io.File;

public class Util {
    private static String getPath(Class<?> cl,String clName){
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clName;
    }
    public static String getPathVarsTxt(){
        return getPath(Util.class, "vars.txt");
    }

}
