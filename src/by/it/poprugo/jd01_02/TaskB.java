package by.it.poprugo.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        step2(month);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    private static void step1() {
        int mas2[][] = new int[5][5];
        int num = 0;
        for (int i = 0; i < mas2.length; i++) {
            for (int j = 0; j < mas2[i].length; j++) {
                num++;
                mas2[i][j] = num;
                System.out.print(mas2[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d < 0) System.out.println("корней нет");
        else if (d == 0) {
            double x1 = (0 - b) / (2 * a);
            System.out.println(x1);
        } //x1=x2
        else {
            double x1 = ((0 - b) + Math.abs(Math.sqrt(d))) / (2 * a);
            double x2 = ((0 - b) - Math.abs(Math.sqrt(d))) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}
