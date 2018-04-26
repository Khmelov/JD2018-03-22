package by.it.fando.Calc;

import java.io.File;

class Util {

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(),"")
                .replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;
    }

    static String getPathVarsTxtPath() {
        return getPath(Util.class,"vars.txt");
    }
}
