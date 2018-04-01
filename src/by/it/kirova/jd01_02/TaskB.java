package by.it.kirova.jd01_02;

import java.util.Scanner;
import java.lang.Math;

public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        System.out.println();
        step2(month);

        System.out.println("Решение квадратного уравнения.");
        System.out.println("Ввведите значения коэффициентов a, b, c (через Enter):");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);

    }

    private static void step3(double a, double b, double c) {
        double d = Math.pow(b, 2) - (4 * a * c);
        if (d < 0) {
            System.out.println("Для коэффициентов a= " + a + " b= " + b + " c= " + c + ":");
            System.out.println("корней нет");
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("Для коэффициентов a= " + a + " b= " + b + " c= " + c + "\n cуществует один корень:" + x);
        } else {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Для коэффициентов a= " + a + " b= " + b + " c= " + c + "\n cуществуют два корня:" + x1 + " , " + x2);
        }
    }


    private static void step1() {
        int size = 5;
        System.out.println("Вывод матрицы формата " + size + "x" + size + " на консоль:");
        int k = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.format("%-2d ", k++);
            }
            System.out.println();

        }
        System.out.println();
    }

    private static void step2(int month) {
        System.out.println("Выбранный вами месяц:");
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
        System.out.println();
    }


}
