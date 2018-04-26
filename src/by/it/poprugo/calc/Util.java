package by.it.poprugo.calc;

import java.io.File;

public class Util {

    private static String getPath(Class<?> cl) { //cl - ? taskAClass
        String path = System.getProperty("user.dir"); //корень JD018...
        path += File.separator + "src" + File.separator; //чтобы слэш - соответствовал системе
        path += cl.getName() //by.it.poprugo.jd01_14.TaskA
                .replace(cl.getSimpleName(), "") // TaskA = cl.getSimpleName()
                .replace(".", File.separator); //заменили точки на правильные (для нашей с-мы) слэши
        return path;
    }

    private static String getPath(Class<?> cl, String fileName) {
        return getPath(cl) + fileName;
    }


    static  String getPathVarsTxt() {
        return getPath(Util.class, "vars.txt");
    }
}
