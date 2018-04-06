package by.it.shvedov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите месяц:");
int mounth= scanner.nextInt();
        step2( mounth);
        System.out.println("Ведите a, b, c ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c= scanner.nextDouble();
        step3(a, b, c);
        step1();
    }

    private static void  step2(int mounth){
       switch (mounth){
           case 1:
               System.out.println("январь");
               break;
           case 2:
               System.out.println("февраль");
               break;
           case 3:
               System.out.println("март");
               break;
           case 4:
               System.out.println("апрель");
               break;
           case 5:
               System.out.println("май");
               break;
           case 6:
               System.out.println("июнь");
               break;
           case 7:
               System.out.println("июль");
               break;
           case 8:
               System.out.println("август");
               break;
           case 9:
               System.out.println("сентябрь");
               break;
           case 10:
               System.out.println("октябрь");
               break;
           case 11:
               System.out.println("ноябрь");
               break;
           case 12:
               System.out.println("декабрь");
               break;
           default:
               System.out.println("нет такого месяца");

       }

    }
    private static void step3(double a, double b, double c) {

        double D = b * b - 4 * a * c;
        double x1, x2;
        if (Math.sqrt(D) < 0) {
            System.out.println("нет корней");
        } else if (Math.sqrt(D) == 0) {
            x1 = (-b) / (2 * a);
            x2 = (-b) / (2 * a);
            System.out.println("x1=" + x1 + "x2=" + x2);
        } else {
            x1 = ((-b) - Math.sqrt(D)) / (2 * a);
            x2 = ((-b) + Math.sqrt(D)) / (2 * a);
            System.out.println("x1=" + x1 + " x2=" + x2);
        }
    }
private static void step1(){
            int i;
            for( i=1; i<=25; i++){
                System.out.print(i+" ");
                if(i%5==0) System.out.println();
            }
    }


}
