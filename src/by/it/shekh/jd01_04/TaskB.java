package by.it.shekh.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] people=new String[n];
        for (int i = 0; i <n ; i++) {
            people[i]=sc.next();
        }

        int [][]salary=new int[n][4];
        for (int i = 0; i <n ; i++) {
            System.out.println("Введите зарплату для "+people[i]);
            for (int j = 0; j <4 ; j++) {
                salary[i][j]=sc.nextInt();
            }
        }
        System.out.printf("Фамилия   Квартал1  Квартал2  Квартал3  Квартал4  Итого\n");
        System.out.println("-----------------------------------------------------------");
        double sum=0;
        int []sumi=new int[n];
        for (int i = 0; i <n ; i++) {
            System.out.printf("%7s:  ",people[i]);
            for (int j = 0; j <4 ; j++) {
                System.out.printf("%-10d",salary[i][j]);
                sumi[i]+=salary[i][j];
                sum+=salary[i][j];
            }
            System.out.printf("%-5d",sumi[i]);
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("Итого    %- 10.0f\n",sum);
        System.out.printf("Средняя   %.4f",sum/(n*4));

    }
}
