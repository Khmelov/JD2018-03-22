package by.it.danilevich.jd02_01;

public class Util {
    static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));
    }

    static void sleep(int countSleep) {
        try {
            Thread.sleep(countSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int count) {
        return random(0, count);
    }
}
