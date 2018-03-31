package by.it.shekh.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {


        int mas[] = new int[10];
        for (int i = 0; i < mas.length; i++) {
            Scanner sc = new Scanner(System.in);
            mas[i] = sc.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);
    }

    static private void step1(int[] mas) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int el : mas) {
            if (el > max) max = el;
            if (el < min) min = el;
        }
        System.out.println(min + " " + max);
    }

    static private void step2(int[] mas) {
        int s = 0;
        for (int el : mas) {
            s += el;
        }
        double mid = (double) s / mas.length;
        System.out.println(s + " " + mid);
        for (int el : mas) {
            if (el < mid) System.out.println(el + " ");
        }
    }

    static private void step3(int[] mas) {

        int min = Integer.MAX_VALUE;
        for (int el : mas) {
            if (el < min) min = el;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}
