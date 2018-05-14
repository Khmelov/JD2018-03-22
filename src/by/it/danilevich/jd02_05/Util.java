package by.it.danilevich.jd02_05;


public class Util {
    static String getPathBundle(Class<?> cl,String nameBundle){
        String path = System.getProperty("user.dir");
        path = cl.getName().replace(cl.getSimpleName(),"");
        path= path+ "ok." + nameBundle;

        return path;
    }

}
