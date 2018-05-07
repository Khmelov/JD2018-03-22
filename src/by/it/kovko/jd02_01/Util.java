package by.it.kovko.jd02_01;

import java.util.Random;

public class Util {
    private static Random r = new Random();
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static int Rnd(int start, int end){
        if (start>end){int tmp=start;start=end;end=tmp;}
        return r.nextInt(end-start+1)+start;
    }
    static int Rnd(int end){return Rnd(0,end);}
    static int Rnd(double percentage){
        if (Math.random()<percentage) return 1;
        return 0;
    }
    static void action(String msg, long timeOut){
        System.out.println(msg); // Если закомментить, то будут выводиться только данные о количестве покупателей в каждую секунду
        Util.sleep(timeOut);
    }
}
