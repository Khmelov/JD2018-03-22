package by.it.sgolovach.jd01_07;

import java.util.Arrays;

public class Matrix extends AbstractVar {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String matrix) {

        char[] ch = matrix.toCharArray();
        int a = 0, b = 0;
        for (char c : ch) {
            if (c == '{') a++;
            if (c == '}') b++;
        }

        if (a != b) System.out.println("Введите правильную матрицу!!!");
        double[][] value1 = new double[a - 1][b - 1];

        String[] str = matrix.split("[^0-9]+");

        int col = 0, strn = 0;
        for (int i = 0; i < str.length; i++) {

            if (i != 0) {
                if (strn == b - 1) {
                    col++;
                    strn = 0;
                }
                if (strn < b - 1) {
                    value1[col][strn] = Double.parseDouble(str[i]);
                    strn++;
                }
            }
        }

        value = value1;

    }


    @Override
    public String toString() {
        String str = new String();
        int b = 0;
        str = str + "{";
        for (int i = 0; i < value.length; i++) {
            b++;
            str = str + "{";
            int a = 0;
            for (int j = 0; j < value.length; j++) {
                a++;
                str = str + value[i][j];
                if (a < value.length) str = str + ", ";
            }
            str = str + "}";
            if (b < value.length) str = str + ", ";
        }
        str = str + "}";
        return str;
    }
}
