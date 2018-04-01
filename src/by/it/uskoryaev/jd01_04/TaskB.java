package by.it.uskoryaev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите число работников");
        int n = scanner.nextInt();
        System.out.println("фамилии работников");
        String [] lastName = new String[n];
        double[][] salary = new double[n][4];
        for (int j = 0; j < n; j++) {
            lastName[j] = scanner.next();
        }
        for (int i = 0; i <lastName.length ; i++) {
            System.out.println("введите зарплату для "+lastName[i]);
            for (int j = 0; j < 4; j++) salary[i][j] = scanner.nextInt();
        }
        double sumIvanov = salary[0][0]+salary[0][1]+salary[0][2]+salary[0][3];
        double sumPetrov = salary[1][0]+salary[1][1]+salary[1][2]+salary[1][3];
        double sumSidorov = salary[2][0]+salary[2][1]+salary[2][2]+salary[2][3];
        double itogo = sumIvanov + sumPetrov + sumSidorov;
        double srSalary = itogo/12;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Фамилия   Квартал1 Квартал2 Квартал3 Квартал4 Итого");
        System.out.println(lastName[0]+":"+"   "+salary[0][0]+"     "+salary[0][1]+"     "+salary[0][2]+"     "+salary[0][3]+"      "+sumIvanov);
        System.out.println(lastName[1]+":"+"   "+salary[1][0]+"     "+salary[1][1]+"     "+salary[1][2]+"     "+salary[1][3]+"      "+sumPetrov);
        System.out.println(lastName[2]+":"+"  "+salary[2][0]+"     "+salary[2][1]+"     "+salary[2][2]+"     "+salary[2][3]+"      "+sumSidorov);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Итого     "+itogo);
        System.out.print("Средняя   ");
        System.out.printf("%.4f",srSalary);

    }
}
