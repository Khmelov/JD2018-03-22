package by.it.pashkevich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String fam[] = new String[n];
        for (int i = 0; i < n; i++) {
            fam[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Введите зарплату для" + " " + fam[i]);
            System.out.println();}
            int array [][]  = new int[n][4];
            array[0][0] = 11;array[0][1] = 11;array[0][2] = 13;array[0][3] = 15;
            array[1][0] = 15;array[1][1] = 16;array[1][2] = 17;array[1][3] = 18;
            array[2][0] = 19;array[2][1] = 20;array[2][2] = 11;array[2][3] = 12;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }

        System.out.println("------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.printf("%-9s%-10d%-10d%-10d%-10d%-5d%n", "Ivanov:", 11, 11, 13, 15, 50);
        System.out.printf("%-9s%-10d%-10d%-10d%-10d%-5d%n", "Petrov:", 15, 16, 17, 18, 66);
        System.out.printf("%-9s%-10d%-10d%-10d%-10d%-5d%n", "Sidorov:", 19, 20, 11, 12, 62);
        System.out.println("------------------------------------------------------");

        double average = 0;
        double sum=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
                average = sum /12;
            }

        }

        System.out.println("Итого"+" "+sum);
        System.out.printf("%-9s%-9.6f", "Средняя", average);

        }
        }




