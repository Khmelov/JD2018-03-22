package by.it.poprugo.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Input number of employees");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        System.out.println("Input names");
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < name.length; i++) {
            System.out.println("Input salary each quarter for " + name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("%9s%-9s%-9s%-9s%-9s%-5s%n", "Фамилия ", "Квартал1 ", "Квартал2 ", "Квартал3 ", "Квартал4 ", "Итого");
        System.out.println("--------------------------------------------------");
        int[] sum = new int[n];
        double total = 0.0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%7s: ", name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-9d", salary[i][j]);
                sum[i] += salary[i][j];
                total += salary[i][j];
            }
            System.out.printf("%-5d%n", sum[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("%-9s%-9d%n", "Итого", (int) total);
        double avr = total / (4 * n);
        System.out.printf("%-9s%-9.4f%n", "Средняя", avr);
    }
}