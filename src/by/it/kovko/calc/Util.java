package by.it.kovko.calc;

import java.io.File;

public class Util {
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += (File.separator + "src" + File.separator);
        path += cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path;
    }

    static String getPathVarsTxt(){
        return getPath(Util.class,"vars.txt");
    }
}
