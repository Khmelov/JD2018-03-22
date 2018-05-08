package by.it.kovko.jd02_02;

import java.util.Random;

public class Helper {
    private static Random r = new Random();
    static void sleep(long timeOut){
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static int Rnd(int start, int end){
        if (start>end){int tmp=start;start=end;end=tmp;}
        return r.nextInt(end-start+1)+start;
    }
    static void action(String msg, long timeOut){
        //System.out.println(msg);
        sleep(timeOut);
    }
    static int Rnd(int end){return Rnd(0,end);}
    static int Rnd(double percentage){
        if (Math.random()<percentage) return 1;
        return 0;
    }
    public static void identation(int index){
        if (index>1)
            System.out.printf("%"+26*(index-1)+"s","");
    }
    public static void whitespaces(int index){
        System.out.printf("%"+(6-index)*26+"s","");
    }
}
