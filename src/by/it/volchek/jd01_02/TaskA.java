package by.it.volchek.jd01_02;

import java.util.Scanner;

/**
 * Created by volchek on 24.03.18.
 */
public class TaskA {
    private static void step1(int[] mas) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {
        int a = 0;
        double mid;
        for (int element : mas) {
            a = a + element;
        }
        mid = a / mas.length;

        for (int element : mas) {
            if (element < mid)
                System.out.print(element + " ");
        }
    }

    private static void step3(int[] mas) {
        int min = Integer.MAX_VALUE;

        for (int element : mas) {
            if (min > element) min = element;
        }
        for (int element = mas.length - 1; element >= 0; element--) {
            if (mas[element] == min) System.out.print(element + " ");

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {

            if (scanner.hasNextInt()) {
                mas[i] = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не целое число");
                break;
            }
        }
        step1(mas);
        step2(mas);
        System.out.println("----------");
        step3(mas);


    }


}
