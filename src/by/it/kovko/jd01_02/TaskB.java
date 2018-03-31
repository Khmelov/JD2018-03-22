package by.it.kovko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        step1();
        Scanner scanner = new Scanner(System.in);
        int month;
        month=scanner.nextInt();
        step2(month);
        double a,b,c;
        a=scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();
        step3(a,b,c);
    }
    private static void step1(){
        for (int i = 0; i <=25 ; i++) {
            System.out.print( i + " ");
            if (i%5==0)
                System.out.println();
        }

    }

    private static void step2(int month){
        switch (month)
        {
            case 1:
                System.out.println("январь"); break;
            case 2:
                System.out.println("февраль");break;
            case 3:
                System.out.println("март"); break;
            case 4:
                System.out.println("апрель");break;
            case 5:
                System.out.println("май"); break;
            case 6:
                System.out.println("июнь");break;
            case 7:
                System.out.println("июль"); break;
            case 8:
                System.out.println("август");break;
            case 9:
                System.out.println("сентябрь"); break;
            case 10:
                System.out.println("октябрь");break;
            case 11:
                System.out.println("ноябрь"); break;
            case 12:
                System.out.println("декабрь");break;
            default:
                System.out.println("нет такого месяца"); break;
        }

    }

    private static void step3(double a, double b, double c){
        double discriminant=b*b-4*a*c;
        if (discriminant>0){
            System.out.print((-b+Math.sqrt(discriminant))/(2*a)+" ");
            System.out.println((-b-Math.sqrt(discriminant))/(2*a));
        }
        else if (discriminant==0){
            System.out.println(-b/(2*a));
        }
        else {
            System.out.println("корней нет");
        }
    }
}
