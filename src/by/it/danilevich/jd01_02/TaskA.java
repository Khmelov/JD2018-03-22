package by.it.danilevich.jd01_02;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args){
        int[] mas = new int[10];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }
    private static void step1(int[ ] mas){
      int min = Integer.MAX_VALUE; //
      int max = Integer.MIN_VALUE;
        for (int elem : mas) {
            if (min > elem) min = elem;
            if (max < elem) max = elem;
        }
        System.out.println(min + " " + max);

    }
    private static void step2(int[ ] mas){
        int sum = 0;
        for (int elem: mas) {
            sum = sum + elem;
        }
        double srednee = (double) (sum/mas.length);
        for (int elem: mas) {
            if (srednee>elem) System.out.print(elem + " ");
        }
        System.out.println();
    }
    private static void step3(int[ ] mas){
        int min = Integer.MAX_VALUE;
        for (int elem : mas) {
            if (min > elem) min = elem;
        }
        for (int i = (mas.length-1); i >= 0; i--) {
            if (min == mas[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println();


    }
}
