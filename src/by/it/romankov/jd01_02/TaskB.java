package by.it.romankov.jd01_02;

import java.util.Scanner;

public class TaskB{
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int month = scaner.nextInt();
        step1();
        step2(month);
        double a = scaner.nextDouble();
        double b = scaner.nextDouble();
        double c = scaner.nextDouble();
        step3(a,b,c);
        }


    static void step1(){
        for ( int i = 1; i <=25 ; i++ ) {
            System.out.print(i+ " ");
            if(i%5==0)
                System.out.println("");

        }
    }

    static void step2(int month){

        switch (month){
            case 1:
                System.out.println("январь");
            case 2:
                System.out.println("февраль");
            case 3:
                System.out.println("март");
            case 4:
                System.out.println("апрель");
            case 5:
                System.out.println("май");
            case 6:
                System.out.println("июнь");
            case 7:
                System.out.println("июль");
            case 8:
                System.out.println("август");
            case 9:
                System.out.println("сентябрь");
            case 10:
                System.out.println("октябрь");
            case 11:
                System.out.println("ноябрь");
            case 12:
                System.out.println("декабрь");
            default:
                System.out.println("нет такого месяца");
        }
    }

    static void step3(double a, double b, double c){
        double dis = b*b - 4* a*c;
        if(dis<0) System.out.println("корней нет");
        else if(dis==0){
            double x = -b/(2*a);
            System.out.println(x);
        }
        else {
            double x1 = (-b+Math.sqrt(dis))/(2*a);
            double x2 = (-b-Math.sqrt(dis))/(2*a);
            System.out.println(x1+" "+x2);
        }
    }

}
