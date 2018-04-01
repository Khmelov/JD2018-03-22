package by.it.fando.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        scan.nextInt();
        String k=scan.next();
        String l=scan.next();
        String m=scan.next();

        System.out.println("Введите зарплату для "+k);
        int num1=scan.nextInt();
        int num2=scan.nextInt();
        int num3=scan.nextInt();
        int num4=scan.nextInt();
        System.out.println("Введите зарплату для "+l);
        int num5=scan.nextInt();
        int num6=scan.nextInt();
        int num7=scan.nextInt();
        int num8=scan.nextInt();
        System.out.println("Введите зарплату для "+m);
        int num9=scan.nextInt();
        int num10=scan.nextInt();
        int num11=scan.nextInt();
        int num12=scan.nextInt();

        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d%n", k, num1, num2, num3, num4, num1+num2+num3+num4);
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d%n", l, num5, num6, num7, num8, num5+num6+num7+num8);
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d%n", m, num9, num10, num11, num12, num9+num10+num11+num12);
        System.out.println("--------------------------------------------------------------------");

        double sum = num1+num2+num3+num4+num5+num6+num7+num8+num9+num10+num11+num12;
        double average = sum/(3*4);
        System.out.printf("%-9s%.0f%n", "Итого", sum);
        System.out.printf("%-9s%.4f", "Средняя", average);


    }

}
