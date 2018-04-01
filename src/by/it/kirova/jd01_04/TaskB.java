package by.it.kirova.jd01_04;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 4;
        System.out.println("Введите число человек:");
        int n = scanner.nextInt();

        System.out.println("Введите фамилии:");
        String[] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = scanner.next();
        }

        int[][] salary = new int[n][size];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + name[i] + "а");
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        int[] summary = getLineSummary(salary, n);
        int resultSummary = getResultSummary(salary);

        double division = getDivision(n, size, resultSummary);

        System.out.println("------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("------------------------------------------------------");

        printTable(salary, name, summary);

        System.out.println("------------------------------------------------------");
        System.out.println("Итого " + resultSummary);
        System.out.print("Средняя");
        System.out.printf("% -10.4f", division);

    }

    private static void printTable(int[][] salary, String[] name, int[] summary) {
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%-10s", name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
            }
            System.out.printf("%-10d", summary[i]);
            System.out.println();
        }
    }


    private static int getResultSummary(int[][] salary) {
        double resSum = 0;
        for (int[] row : salary) {
            for (int element : row) {
                resSum = resSum + element;
            }
            System.out.println();
        }
        return (int) resSum;
    }

    // В тесте ошибка. В квартале 3 месяца, среднеарифметическая месячная зарплата равна среднеквартальной деленной на 3.
    // Тест не пропускает деление на 3, т.к. полученное на проверку значение сравнивает со значением среднеквартальной зарплаты.
    private static double getDivision(int n, int size, int resultSummary) {
        double count = n * size;
        double resDiv = resultSummary / count;
        return resDiv;
    }

    private static int[] getLineSummary(int[][] salary, int n) {
        int[] sum = new int[n];
        for (int i = 0; i < salary.length; i++) {
            int summary = 0;
            for (int j = 0; j < salary[i].length; j++) {
                summary = summary + salary[i][j];
            }
            sum[i] = summary;
        }
        return sum;
    }


}


