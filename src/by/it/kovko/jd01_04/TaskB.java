package by.it.kovko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String surnames[] = new String[n];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = scanner.next();
        }
        int salary[][] = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j]=scanner.nextInt();
            }
        }
        System.out.println(String.format("%60s"," ").replace(' ','_'));
        System.out.printf("\n%10s%10s%10s%10s%10s%10s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(String.format("\n%60s"," ").replace(' ','_'));
        int totalTotal=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("\n%10s:", surnames[i]);
            int total=0;
            for (int j = 0; j < 4; j++) {
                total+=salary[i][j];
                System.out.printf("%-10d", salary[i][j]);
            }
            System.out.printf("%-10d", total);
            totalTotal+=total;
        }
        System.out.println(String.format("\n%60s"," ").replace(' ','_'));
        System.out.printf("\n%10s%10d", "Итого:", totalTotal);
        System.out.printf("\n%10s%10f", "Средняя:", (double)totalTotal/(4*n));


    }
}
