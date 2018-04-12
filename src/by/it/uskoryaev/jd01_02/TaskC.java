//package by.it.uskoryaev.jd01_02;
//
//import java.util.Scanner;
//
//public class TaskC {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int [] [] mas = new int[n][n];
//
//        step1(n);
//        step2(mas);
//        step3(mas);
//
//
//    }
//    static int[ ][ ] step1(int n) {
//        boolean inspection=false;
//        int[][] mas = new int[n][n];
//        do {
//            for (int i = 0; i < mas.length; i++) {
//                for (int j = 0; j < mas[i].length; j++) {
//                    int numberRandom = (int) Math.random() * n - n;
//                    if (mas[i][j] == numberRandom){
//                        inspection = true;
//                    }else {
//                        inspection = false;
//                    }
//                }
//            }
//        }while (inspection){
//            for (int i = 0; i <mas.length ; i++) {
//                for (int j = 0; j <mas.length ; j++) {
//                    System.out.print(mas[i][j]+" ");
//                }
//                System.out.println();
//            }
//            return mas;
//        }
//    }
//
//
//    static int step2(int[ ][ ] mas){
//
//    }
//
//    static int[ ][ ] step3(int[ ][ ] mas){
//
//    }
//
//}
