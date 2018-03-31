package by.it.sgolovach.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scaner = new Scanner(System.in);

        step1();

        int month = scaner.nextInt();
        step2(month);

        double a = scaner.nextInt();
        double b = scaner.nextInt();
        double c = scaner.nextInt();
        step3(a, b, c);

    }

    private static void step1() {
        int num = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                num++;
                System.out.print(num + " ");
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

        double dis = b * b - 4 * a * c;

        if (dis > 0) {
            double x1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (dis == 0) {
            double x = (-b) / (2 * a);
            System.out.println(x);
        } else System.out.println("корней нет");
    }
}
