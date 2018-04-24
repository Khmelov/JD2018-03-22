package by.it.volchek.jd01_04;

import java.util.Scanner;

/**
 * Created by volchek on 29.03.18.
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menNumber = scanner.nextInt();
        String[] surnames = new String[menNumber];
        for (int i = 0; i < surnames.length; i++) {
            System.out.println("Введите фамилию №" + i + 1);
            surnames[i] = scanner.next();
        }
        int[][] salary = new int[surnames.length][4];
        for (int i = 0; i < surnames.length; i++) {
            System.out.println("Введите зарплату для " + surnames[i] + "а");
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }

        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Фамилия     Квартал1    Квартал2    Квартал3    Квартал4");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < surnames.length; i++) {
            System.out.printf("%-10s", surnames[i]);
            // System.out.print(surnames[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%12d", salary[i][j]);

            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println();

        }
        double totalSalary = 0;
        int salaryCount = 0;
        for (int[] element : salary) {
            for (int subElement : element) {
                totalSalary = totalSalary + subElement;
                salaryCount++;
            }
        }
        double averageSalary = totalSalary / salaryCount;
        System.out.println("Итого:  " + totalSalary);
        System.out.println("Средняя:  " + averageSalary);





        /*for (String a:surnames) {
            System.out.print(a+" ");

        }
        System.out.println();
        for (int i[]:salary) {
            for (int j: i) {
                System.out.print(j+" ");
            }
            System.out.println();

        }*/

    }
}
