package by.it.kirova.jd02_02;

class Util {
    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout / Dispatcher.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void randomSleep(int from, int to, double k) {
        sleep((int)(random(from, to) * k));
    }


    static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));
    }

    static int random(int count) {
        return random(0, count);
    }
}
