package by.it.kirova.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mas[] = new int[10];
        System.out.println("Введите 10 чисел через пробел:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);

    }

    private static void step1(int[] mas) {
        System.out.println("Вывод минимального и максимального значения из введенного массива:");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int element : mas) {
            if (element < min)
                min = element;
            else if (element > max)
                max = element;
        }
        System.out.print(min + " " + max);
        System.out.println();
    }

    private static void step2(int[] mas) {
        System.out.println("Вывод чисел, значение которых строго меньше среднего\n" +
                "арифметического в этом массиве:");
        double avg = 0;
        for (int element : mas) {
            avg = avg + element;
        }
        avg = avg / mas.length;
        for (int element : mas)
            if (element < avg) {
                System.out.print(element + " ");
            }
        System.out.println();
    }

    private static void step3(int[] mas) {
        System.out.println("Идексы минимальных значений из введенного массива (в порядке убывания):");
        int min = Integer.MAX_VALUE;
        for (int element : mas) {
            if (element < min)
                min = element;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}