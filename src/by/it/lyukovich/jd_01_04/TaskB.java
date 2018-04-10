package by.it.lyukovich.jd_01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer peopleC = sc.nextInt();
        String[] arr = new String[peopleC];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        Double[][] zp = new Double[peopleC][4];
        for (int i = 0; i < peopleC; i++) {
            System.out.println("Введите зарплату для " + arr[i]);
            for (int j = 0; j < 4; j++) {
               zp[i][j] = sc.nextDouble();
            }
        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n","Фамилия","Квартал 1","Квартал 2","Квартал 3","Квартал 4",
                "Итого");
        double total = 0;
        int summass=0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-10s", arr[i]);
            double itog = 0;

            for (int j = 0; j < 4; j++) {
                itog= itog+zp[i][j];
                System.out.printf("%-10s",zp[i][j]);
                summass=summass+1;
            }
            total=total+itog;
            System.out.printf("%-10s", itog);
            System.out.println();
        }
        System.out.printf("%-10s%-10s%n","Итого",total);
        System.out.printf("%-10s%-10s%n","Средняя",total/summass);
    }

    }
