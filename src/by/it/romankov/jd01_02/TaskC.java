package by.it.romankov.jd01_02;

import java.util.Arrays;
import java.util.Random;

public class TaskC {
    static int[ ][ ] step1(int n){
        Random random = new Random();
        int test = random.nextInt(2*n)-n;
        boolean positive = false;
        boolean negotive = false;
        int [][] res = new int[n][n];
        while ((!positive && !negotive))
        for ( int i = 0; i < res.length; i++ ) {
            for ( int j = 0; j <res[i].length ; j++ ) {
                int k = random.nextInt(2*n+1)-n;
                if(k==-n) negotive = true;
                if(k==-n) positive = true;
                res[i][j]=k;

            }

        }
              for ( int[] row:res ) {
            System.out.println(Arrays.toString(res));

        }
        return res;
    }
    static int step2(int[ ][ ] mas){
        int res=0;
        boolean start;
        boolean stop;
        for ( int[] row : mas ) {
            int i =0;
            while (i<row.length &&row[i]<=0) i++;
            i++;
            while (i<row.length &&row[i]<=0) {
                res+=row[i];
            i++;
            }

        }
        return res;


    }




}
