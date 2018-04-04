package by.it.kovko.jd01_06;

import java.util.Random;

public class TaskC2 {
    private static int seed=16;
    private static int maxCharacters=10000;
    public static void main(String[] args) {

        long startSlow, workingTimeSlow;
        startSlow=System.nanoTime();
        System.out.println(slow(Poem.text));
        workingTimeSlow=System.nanoTime()-startSlow;
        System.out.println("slow dt=" + workingTimeSlow);

        long startFast, workingTimeFast;
        startFast=System.nanoTime();
        System.out.println(fast(Poem.text));
        workingTimeFast=System.nanoTime()-startFast;
        System.out.println("fast dt=" + workingTimeFast);




    }

    private static String fast(String text){
        String words[];
        String regex = "[^А-Яа-яёЁ]+";
        words=text.split(regex);
        int maxRand=words.length;
        Random r = new Random(seed);
        StringBuilder space = new StringBuilder(" ");
        StringBuilder sb[] = new StringBuilder[words.length];
        for (int i = 0; i < words.length; i++)
            sb[i] = new StringBuilder(words[i]);
        StringBuilder result= new StringBuilder();
        result.ensureCapacity(100000);
        while (result.length()<maxCharacters)
            result.append(sb[r.nextInt(maxRand)]).append(space);

        return result.toString();
    }

    private static String slow(String text){
        String words[];
        String regex = "[^А-Яа-яёЁ]+";
        words=text.split(regex);
        int maxRand=words.length;
        Random r = new Random(seed);
        String slowResult="";
        while(slowResult.length()<maxCharacters)
            slowResult=slowResult.concat(words[r.nextInt(maxRand)]+" ");
        return slowResult;
    }
}
