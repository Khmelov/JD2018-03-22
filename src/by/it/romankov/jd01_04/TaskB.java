package by.it.romankov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String line = scanner.nextLine();
        String[] strArr = new String[n];
        for ( int i = 0; i < n; i++ ) {
            strArr[i]=scanner.next();

        }

        int N = n;
        int[][] mas = new int[N][4];
        for ( int i = 0; i < mas.length; i++ ) {

            System.out.println("введите зарплату для " + strArr[i]);


            for ( int j = 0; j < mas[0].length; j++ ) {
                mas[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        for ( int i = 0; i < mas.length; i++ ) {
            for ( int j = 0; j < mas[0].length; j++ ) {
                System.out.printf("%-10d", mas[i][j]);
            }
            System.out.println();

        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("--------------------------------------------------------");
        int sumAll = 0;
        for ( int i = 0; i < mas.length; i++ ) {
            int sum = 0;
            System.out.printf("%-10s", strArr[i]);
            for ( int j = 0; j < mas[0].length; j++ ) {
                System.out.printf("%-10d", mas[i][j]);
                sum = sum + mas[i][j];
                sumAll = sumAll + mas[i][j];
            }
            System.out.printf("%-6d", sum);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10d", "Итого", sumAll);
        System.out.println();
        double sumAll2 = (double) sumAll;
        double middle = sumAll2 / (n * (mas.length + 1));
        System.out.printf("%-10s%-10.4f", "Средняя", middle);
    }
}

