package by.it.shvedov.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum=0;
        String[] mas = new String[n];
        int[][] array = new int[n][4];
        for (int i = 0; i < n; i++) {
            mas[i] = scanner.next();
        }
      for (int i=0; i<mas.length; i++){
          System.out.println("Введите зарплату "+mas[i]);
          for(int j=0; j<4; j++){
              array[i][j]=scanner.nextInt();
          }
      }
        System.out.println("Фамилия Квартал1 квартал2 Квартал3 Квартал4 Итог");
        System.out.println("-------------------------------------------------");
        for(int i=0; i<mas.length; i++){
            System.out.printf("%-7s:",mas[i]);
            for(int j=0; j<4; j++){
                System.out.printf("%-9d",array[i][j]);
                //sum+=array[i][j];
                //System.out.printf("%-1d",sum);
            }
            System.out.println();
        }

        }
    }





