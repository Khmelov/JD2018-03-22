package by.it.verishko.jd01_04;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] line = new String[n];
        for (int i = 0; i < line.length; i++) {
            line[i] = sc.next();
        }
        int[][] mas = new int[n][4];
        for (int i = 0; i < mas.length; i++) {
            System.out.println("Введите зп " + line[i] + "(-a) ");
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = sc.nextInt();
            }
        }
        int sum1 = mas[0][0] + mas[0][1] + mas[0][2] + mas[0][3];
        int sum2 = mas[1][0] + mas[1][1] + mas[1][2] + mas[1][3];
        int sum3 = mas[2][0] + mas[2][1] + mas[2][2] + mas[2][3];
        int all = mas[0][0] + mas[0][1] + mas[0][2] + mas[0][3] + mas[1][0] + mas[1][1] + mas[1][2] + mas[1][3] + mas[2][0] + mas[2][1] + mas[2][2] + mas[2][3];
        double sre = (double) all / ((mas.length + 1) * line.length);

        System.out.print("Фамилия Квартал1 Квартал2 Квартал3 Квартал4 Итого \n");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-8s%-9d%-9d%-9d%-9d%-9d%n", line[0], mas[0][0], mas[0][1], mas[0][2], mas[0][3], sum1);
        System.out.printf("%-8s%-9d%-9d%-9d%-9d%-9d%n", line[1], mas[1][0], mas[1][1], mas[1][2], mas[1][3], sum2);
        System.out.printf("%-8s%-9d%-9d%-9d%-9d%-9d%n", line[2], mas[2][0], mas[2][1], mas[2][2], mas[2][3], sum3);
        System.out.println("-----------------------------------------------------");
        System.out.println("Итого " + all);
        System.out.printf("%-8s%-5.4f", "Средняя", sre);
    }
}

