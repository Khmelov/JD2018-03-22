package by.it.akhmelev.calc;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }

    Matrix(String strValue) {
        String[] rows = strValue.split("},");
        String[][] cells = new String[rows.length][0];
        for (int i = 0; i < rows.length; i++) {
            cells[i] = rows[i]
                    .replace('{', ' ').replace('}', ' ')
                    .trim().split(",\\s*");
        }
        value = new double[cells.length][cells[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(cells[i][j]);
            }
        }
    }

    Matrix(Matrix m) {
        this(m.value);
    }

    @Override
    public String toString() {
        String[] rows=new String[value.length];

        for (int i = 0; i < value.length; i++) {
            rows[i]=Arrays.toString(value[i]);
        }

        return Arrays.toString(rows)
                .replace('[', '{')
                .replace(']', '}');
    }
}
