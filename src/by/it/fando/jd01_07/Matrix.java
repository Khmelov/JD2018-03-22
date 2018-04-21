package by.it.fando.jd01_07;

import java.util.Arrays;

public class Matrix extends AbstractVar {

    private double [][] value;

    Matrix (double[][] value) {
        this.value = value;
    }


    Matrix (Matrix matrix) {
        this.value = matrix.value;
    }


    Matrix (String strMatrix) {


    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            sb.append(Arrays.toString(value[i]));

            sb.append("}");
        }
        sb.append("}");

        return sb.toString();
    }
}
