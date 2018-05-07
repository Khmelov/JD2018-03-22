package by.it.shvedov.jd02_01;

public class Util {
    static void sleep(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
