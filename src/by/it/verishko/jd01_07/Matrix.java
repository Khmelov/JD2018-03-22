package by.it.verishko.jd01_07;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;

//    Matrix(double[][] value) {
//        this.value = value;
//    }

//    Matrix(Matrix matrix) {
//        this.value = matrix.value;
//    }

    Matrix(String strMatrix) {

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();


        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
