package by.it.lyukovich.jd_01_02;

import java.util.Scanner;

public class TaskC {
    static int n;
    public static void main(String[] args) {
        int[][] sourceMatrix;
        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        sourceMatrix = step1(n);
        printMas(sourceMatrix);
        System.out.println(step2(sourceMatrix));
        printMas(step3(sourceMatrix));
    }
    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        do {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = random(-10,10);
                }
            }
        } while (!masCheck(mas, n));
      return mas;
    }
    private static Boolean masCheck(int[][] mas, int n){
        boolean n1= false, n2= false;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == n) n1=true;
                if (mas[i][j] == -n) n2=true;
            }
        }
        if (n1 && n2) return true; else return false;
    }

    private static int step2(int[][] mas) {
        int sum=0;
        for (int i = 0; i < mas.length; i++) {
            boolean start=false, end=false;
            for (int j = 0; j < mas[i].length; j++) {
                int el=mas[i][j];
                if (el>=0 && start && !end) end=true;
                else if (el>=0 && !start) start = true;
                else if (start && !end) sum+=el;
            }
        }
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = findMax(mas);
        int l = mas.length;
        boolean[] rList = new boolean[l];
        boolean[] cList = new boolean[l];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    rList[i] = true;
                    cList[j] = true;
                }
            }
        }
        int[][] newMas = new int[countSize(rList)][countSize(cList)];
        int i1 = 0;
        for (int i = 0; i < mas.length; i++) {
            int j1 = 0;
            if (!rList[i]){
                for (int j = 0; j < mas[i].length; j++) {
                    if (!cList[j]) {
                        newMas[i1][j1] = mas[i][j];
                         j1++;
                    }
                }
                i1++;
            }
        }
        return newMas;
    }

    private static int countSize (boolean[] mas){
        int sum=0;
        for (int i = 0; i < mas.length; i++) {
            if (!mas[i]) sum+=1;
        }
        return sum;
    }

    private static int findMax (int [][] mas){
        int max=0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (max<mas[i][j]) max=mas[i][j];
            }
        }
        System.out.println("Max = " + max);
        return max;
    }
    private static void printMas(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
    private static int random(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

}
