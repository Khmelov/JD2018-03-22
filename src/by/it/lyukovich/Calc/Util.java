package by.it.lyukovich.Calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Util {
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    public static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

    static String getPathVarsTxt() throws IOException {
        String path = getPath(Util.class,"vars.txt");
        File file = new File(path);
        if (!file.exists()) {varsWriter(path);}
        return path;
    }

    public static void varsWriter(String path) throws IOException {
        String empty = "";
        BufferedWriter output = null;
        try {
            File file = new File(path);
            output = new BufferedWriter(new FileWriter(file));
            output.write(empty);
        } catch ( IOException e ) {
                e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }
    }
}
