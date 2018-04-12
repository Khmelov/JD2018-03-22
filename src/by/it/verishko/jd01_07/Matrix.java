package by.it.verishko.jd01_07;

import java.util.Arrays;


public class Matrix extends AbstractVar {
    private double value[][];

    Matrix(double[][] value) {
        this.value = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            this.value[i] = Arrays.copyOf(matrix.value[i], matrix.value[i].length);
        }
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{]+", "") + "},";
        String lines[] = strMatrix.split("[}]+,");
        value = new double[lines.length][];
        String line[];
        for (int i = 0; i < lines.length; i++) {
            line = lines[i].split(",");
            value[i] = new double[line.length];
            for (int j = 0; j < line.length; j++) {
                value[i][j] = Double.parseDouble(line[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            result.append("{").append(Arrays.toString(value[i]).replaceAll("[\\[\\]]", "")).append("}");
            if (i < value.length - 1)
                result.append(" ,");
        }
        result.append("}");
        return result.toString();
    }
}