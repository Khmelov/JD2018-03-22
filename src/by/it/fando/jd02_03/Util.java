package by.it.fando.jd02_03;

class Util {
    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout / Controller.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int random (int from, int to) {
        return from + (int) (Math.random()*(1 + to - from));
    }

    static int random (int count) {
        return random(0, count);
    }

}
