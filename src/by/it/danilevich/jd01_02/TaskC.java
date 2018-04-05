package by.it.danilevich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int razm = sc.nextInt();
        int mas[][] = step1(razm);
        step2(mas);
        step3(mas);
    }

    private static int[ ][ ] step1(int n){
        int mas[][] = new int[n][n];
        int havePlusN = 0, haveMinusN =0;
        while (haveMinusN==0 || havePlusN ==0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int rand = (int)( Math.random() * (n + n+1) ) - n;
                    mas[i][j] = rand;
                    if (rand == n) havePlusN = 1;
                    if (rand == (-n)) haveMinusN = 1;
                }
            }
            if (haveMinusN == 1 && havePlusN ==1)
                break;
            else {
                haveMinusN =0;
                haveMinusN =0;
            }
         }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }

    private static int step2(int[ ][ ] mas){
        int sum = 0;
        int firstPlus=0, secondPlus=0;
        int havePlus1= 0, havePlus2 = 0;
        for (int i = 0; i < mas.length; i++) {
            havePlus1= 0;
            havePlus2 = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > 0){
                    if (havePlus1 == 0){
                        havePlus1 = 1;
                        firstPlus = j;
                    }
                    else{
                        havePlus2 = 1;
                        secondPlus =j;
                    }
                }
                if (havePlus1 == 1 && havePlus2 == 1){
                    for (int k = (firstPlus+1); k < secondPlus; k++) {
                        sum = sum + mas[i][k];
                    }
                 break;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }
    private static int[ ][ ] step3(int[ ][ ] mas){

       int max = Integer.MIN_VALUE;
       String spisStrok="", spisStolb="";
       for (int[] elem : mas) {
            for (int el : elem) {
                if (max < el) max = el;
            }
       }
       for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (max == mas[i][j]){
                    if (spisStolb.contains(j+" ")==false)spisStolb = spisStolb + j+" ";
                    if (spisStrok.contains(i+" ")==false) spisStrok = spisStrok + i +" ";
                }
            }
       }

        String[] masStolbStr = spisStolb.split(" ");
        String[] masStrokStr = spisStrok.split(" ");

        int[] masStolb = new int[masStolbStr.length];
        int[] masStrok = new int[masStrokStr.length];

        for (int i = 0; i < masStrokStr.length; i++) {
            masStrok[i] = Integer.parseInt(masStrokStr[i]);
        }
        for (int i = 0; i < masStolb.length; i++) {

            masStolb[i] = Integer.parseInt(masStolbStr[i]);
        }

       int newMas[][] = new int[mas.length - masStrok.length][mas[0].length - masStolb.length];
       int needStolb = 1, needStroka =1;
       int k1 =0, k2 =0;
       for (int i = 0; i < mas.length; i++) {
           needStroka = 1;
           for (int ii = 0; ii <masStrok.length ; ii++) {
               if (i == masStrok[ii]) {
                   needStroka = 0;
                   break;
               }
           }
           if (needStroka==0) continue;
           k2 = 0;
           for (int j = 0; j < mas[i].length; j++) {
               needStolb =1;
               for (int jj = 0; jj < masStolb.length; jj++) {
                   if (masStolb[jj] == j){
                       needStolb = 0;
                       break;
                   }
               }
              if (needStolb ==1){
                   newMas[k1][k2] = mas[i][j];
                   k2=k2+1;
              }


            }
            k1 = k1 +1;

        }
        for (int [] elem:newMas) {
            for (int el: elem) {
                System.out.print(el + " ");

            }
            System.out.println();
        }



       return newMas;
    }

}
