package by.it.sgolovach.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int n = scaner.nextInt();
        int itogo = 0;

        String[] name = new String[n];
        int[][] kvartal = new int[n][4];
        int[] sum = new int[n];
        String[] zag = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};

        for (int i = 0; i < n; i++) {
            String fam = scaner.next();
            name[i] = fam;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < 4; j++) {
                int salary = scaner.nextInt();
                kvartal[i][j] = salary;
                itogo = itogo + salary;
            }
            sum[i] = itogo;
        }

        for (int i = 0; i < zag.length; i++) {
            System.out.print(zag[i] + "   ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(name[i] + ":");
            for (int j = 0; j < 4; j++) {
                System.out.print(kvartal[i][j] + "    ");
            }
            System.out.print(sum[i]);
            System.out.println();
        }

        double avg = (double) itogo / 12;

        System.out.println("Итого   " + itogo);
        System.out.println("Средняя  " + avg);
    }
}
