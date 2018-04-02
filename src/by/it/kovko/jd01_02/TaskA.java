package by.it.kovko.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }
    private static void step1(int[ ] mas){
        int min=Integer.MAX_VALUE ,max=Integer.MIN_VALUE;

        for (int x:mas){
            min=(min>x)?x:min;
            max=(max<x)?x:max;
        }
        System.out.println(min +" " + max);
    }

    private static void step2(int[ ] mas){
        double mean;
        int sum = 0;
        for (int x: mas){
            sum+=x;
        }
        mean=(double)sum/mas.length;
        for (int x:mas){
            if (x<mean)
                System.out.print(x + " ");
        }
    }

    private static void step3(int[ ] mas){
        int min=Integer.MAX_VALUE;

        for (int ma : mas) {
            min = (min > ma) ? ma : min;
        }

        for (int i = mas.length-1; i >=0 ; i--) {
            if (mas[i]==min)
                System.out.print(i+ " ");
        }
    }
}

