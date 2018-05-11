package by.it.lyukovich.jd_02_01;

public class Util {
    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void randomSleep(int from, int to, double par) {
        sleep((int)(random(from, to) * par));
    }


    static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));

    }

}
