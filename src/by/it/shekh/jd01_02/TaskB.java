package by.it.shekh.jd01_02;

import java.util.Scanner;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        int mm = sc.nextInt();
        step2(mm);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);

    }

    private static void step1() {
        int a = 1;
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(a + " ");
                a++;
            }
            System.out.println();
        }
    }

    private static void step2(int month) {

        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");

            }
        }
    }

    private static void step3(double a, double b, double c) {
        double D = pow(b, 2) - 4 * a * c;
        if (D < 0) System.out.println("корней нет");
        else if (D == 0) {
            double ro = (-b) / (2 * a);
            System.out.println(ro);
        } else {
            double se = ((-b) + sqrt(D)) / (2 * a);
            double fi = ((-b) - sqrt(D)) / (2 * a);
            System.out.println(se + " " + fi);
        }
    }
}
