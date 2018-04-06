package by.it.desykevich.jd01_04;

import javax.naming.Name;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число фамилий:");
        int n = scanner.nextInt();
        String[] arr = new String[n];
        System.out.println("Фамилии:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();
            System.out.println();

        }

        int[][] arr2 = new int[n][4];

        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Введите зарплату для" + " " + arr[i]);
            for (int j = 0; j < arr2[0].length; j++) {

                arr2[i][j] = scanner.nextInt();

            }
        }

        printTable(arr,arr2);
    }

    private static void printTable(String[] arr, int[][] arr2) {
        int avg,sum=0;
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i <arr2.length ; i++) {
            avg=0;
            System.out.printf("%-10s",arr[i]+":");
            for (int j = 0; j <arr2[0].length ; j++) {
                avg+=arr2[i][j];
                System.out.printf("% -10d",arr2[i][j]);
            }
            sum=sum + avg;
            System.out.printf("%-10d\n",avg);
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10d\n","Итого",sum);
        System.out.printf("%-10s%-10f","Средняя",(double)sum/(arr2.length*arr2[0].length));
    }
}