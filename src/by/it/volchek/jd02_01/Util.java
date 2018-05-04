package by.it.volchek.jd02_01;

/**
 * Created by volchek on 26.04.18.
 */
public class Util {
     static void sleep(int msTimeOut) {

        try {
            Thread.sleep(msTimeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static int random (int from, int to){
       return from+(int)(Math.random()*(to-from+1));
    }
    static int random (int count){
        return random(0,count);
    }
}
