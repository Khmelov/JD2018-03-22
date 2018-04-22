package by.it.volchek.jd01_02;

import java.util.Scanner;

/**
 * Created by volchek on 24.03.18.
 */
public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        step2(i);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);

    }

    private static void step3(double a, double b, double c) {
        if ((b * b - 4 * a * c) < 0) System.out.println("корней нет");
        else if ((b * b - 4 * a * c) == 0) System.out.println(-b / a / 2);
        else
            System.out.println((-b + Math.sqrt(b * b - 4 * a * c)) / a / 2 + " " + (-b - Math.sqrt(b * b - 4 * a * c)) / a / 2);

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
                break;


        }
    }

    private static void step1() {
        int a = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (a < 10) System.out.print(" " + a++ + " ");
                else System.out.print(a++ + " ");

            }
            System.out.println();

        }
    }

}
