package by.it.poprugo.jd02_01;

class Util {
    static void sleep (int msTimeout) {
       try {
           Thread.sleep(msTimeout);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    static int random (int from, int to) {
        return from + (int) (Math.random()*(to-from)+1);
    }

    static int random (int count) {
        return random(0,count);
    }
}
