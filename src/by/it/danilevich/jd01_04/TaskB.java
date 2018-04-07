package by.it.danilevich.jd01_04;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int countPeople = sc.nextInt();
     sc.nextLine();
     int[][] salary = new int[countPeople][4];
     String[] people = new String[countPeople];
     for (int i = 0; i < countPeople; i++) {
        people[i] = sc.next();
     }
     sc.nextLine();
     for (int i = 0; i < countPeople; i++) {
         System.out.println("Введите зарплату для " + people[i]);
         String salaryS = sc.nextLine();
         salary[i]= InOut.getArrayToInt(salaryS);
     }
     System.out.println("-------------------------------------------");
     System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n","Фамилия", "Квартал1", "Квартал2","Квартал3", "Квартал4", "Итого");
     System.out.println("-------------------------------------------");
     int itogo = 0;
     for (int i = 0; i < people.length; i++) {
        int sum = salary[i][0]+salary[i][1]+salary[i][2]+salary[i][3];
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d%n",people[i], salary[i][0], salary[i][1],salary[i][2], salary[i][3], sum);
        itogo = itogo + sum;
     }
        System.out.println("-------------------------------------------");
        System.out.printf("%-10s%-10d%n","Итого", itogo);
        double sredn = (double) (itogo)/(countPeople*4);
        System.out.printf("%-10s%-10.4f%n","Средняя", sredn);

    }
}
