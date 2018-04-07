package by.it.akhmelev.jd01_08;


public class Matrix extends Var {

    private double[][] arr;

    Matrix(double[][] value) {
        this.arr = value;
    }

    Matrix(Matrix matrix) {
        this.arr = matrix.arr;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(2, strMatrix.length() - 2);
        String[] row = strMatrix.split("},\\{");

        for (int i = 0; i < row.length; i++) {
            String[] strValues = row[i].split(",( *)");
            if (arr == null)
                arr = new double[row.length][strValues.length];
            for (int j = 0; j < strValues.length; j++) {
                arr[i][j] = Double.parseDouble(strValues[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < arr.length - 1; i++) {
            rowToString_Impl(sb, i);
            sb.append(",");
        }
        rowToString_Impl(sb, i);
        return "{" + sb.toString() + "}";

    }


    private void rowToString_Impl(StringBuilder sb, int i) {
        sb.append("{");
        for (int j = 0; j < arr[i].length - 1; j++) {
            sb.append(arr[i][j]).append(",");
        }

        sb.append(arr[i][arr[i].length - 1]).append("}");
    }
}

