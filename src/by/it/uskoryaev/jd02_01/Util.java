package by.it.uskoryaev.jd02_01;

public class Util {
    static void sleep(int msTineout) {
        try {
            Thread.sleep(msTineout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));
    }
    static int random(int count){return random(0,count);}
}
