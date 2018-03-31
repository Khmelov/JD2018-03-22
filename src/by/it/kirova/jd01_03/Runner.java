package by.it.kirova.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите значения массива (через пробел):");
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);


        System.out.println("Вывод простой и форматированной печати:");
        InOut.printArray(array);
        int column = 5;
        String name = "v";
        InOut.printArray(array, name, column);



        double min = Helper.findMin(array);
        System.out.println("Минимальное число из массива равно: " + min);



        double max = Helper.findMax(array);
        System.out.println("Максимальное число из массива равно: " + max);




        System.out.println("Отсортированный массив в порядке возрастания значений: ");
        Helper.sort(array);




        System.out.println("Введите размерность матрицы n:");
        int n = scanner.nextInt();
        System.out.println("Введите размерность матрицы m:");
        int m = scanner.nextInt();
        double[][] mat = Helper.CreateMatrix(n, m);
        InOut.printMatrix(mat);
        System.out.println();
        double[] vec = Helper.CreateVector(m);
        InOut.printVectorVert(vec);
        System.out.println("Результат умножения матрицы на вектор:");
        double[] mulMatVec = Helper.mul(mat, vec);
        InOut.printVectorHor(mulMatVec);




        System.out.println("Введите размерность матрицы n:");
        int n1 = scanner.nextInt();
        System.out.println("Введите размерность матрицы m:");
        int m1 = scanner.nextInt();
        System.out.println("Введите размерность матрицы k:");
        int k1 = scanner.nextInt();
        double[][] left = Helper.CreateMatrix(n1, m1);
        System.out.println("Матрица размером N x M:");
        InOut.printMatrix(left);
        double[][] right = Helper.CreateMatrix(m1, k1);
        System.out.println("Матрица размером M x K:");
        InOut.printMatrix(right);
        System.out.println("Результат умножения матрицы N x M на матрицу M x K:");
        double[][] mulMatMat = Helper.mul(left, right);
        InOut.printMatrix(mulMatMat);

    }
}

