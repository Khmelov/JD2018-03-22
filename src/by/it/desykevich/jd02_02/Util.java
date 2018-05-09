package by.it.desykevich.jd02_02;

import java.util.Random;

class Util {

    private final static Random random = new Random();

    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout / Dispatcher.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static void sleep(int start, int stop) {

        try {Thread.sleep(random(start, stop));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random(int start, int stop) {

//        return from + (int) (Math.random() * (1 + to - from));
        return random.nextInt(stop - start) + 1;
    }

    static int random(int count) {
//        return random(0, count);
        return random.nextInt(count);
    }
}
