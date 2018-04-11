package by.it.poprugo.jd01_08;

import by.it.poprugo.jd01_08.Var;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] strings = new String[0];
        strings = strMatrix.split("},");
        int rowNum = strings[0].split(",").length; // костыль: матрица прямоугольная
        double[][] arrParsed = new double[strings.length][rowNum];
        for (int i = 0; i < strings.length; i++) {
            String[] rows = new String[0];
            rows = strings[i].split(",");
            for (int j = 0; j < rows.length; j++) {
                rows[j] = rows[j].replaceAll("[^(\\d+.?\\d+)]", " ").trim();
                arrParsed[i][j] = Double.parseDouble(rows[j]);
            }
        }
        this.value = arrParsed;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            System.out.println("v= "+v);
            //Vector res=new Vector(this);
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    System.out.print(" value="+value[i][j]+", res:"+res[i][j]);
                    res[i][j] = res[i][j] + v;
                    System.out.println(" - > res:"+res[i][j]);
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            Vector vector = ((Vector) other);
            return super.add(other);
        } else if (other instanceof Matrix) {
            Matrix matrixAdd = ((Matrix) other);
            double[][] resAdd = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resAdd.length; i++) {
                for (int j = 0; j < resAdd[i].length; j++) {
                    System.out.println("resAdd: "+resAdd[i][j]+", matrixAdd.value: "+matrixAdd.value[i][j]+", value: "+value[i][j]);
                    resAdd[i][j] = resAdd[i][j] + matrixAdd.value[i][j];
                }
            }
            return new Matrix(resAdd);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            //Vector res=new Vector(this);
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] -= v;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            Vector vector = ((Vector) other);
            return super.sub(other);
        } else if (other instanceof Matrix) {
            Matrix matrix = ((Matrix) other);
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] -= value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public String toString() {
        StringBuilder sbM = new StringBuilder("{{");
        String signBoundRow = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sbM.append(signBoundRow).append(value[i][j]);
                if (j < value[i].length - 1) signBoundRow = ", ";
                else signBoundRow = "}, {";
            }
        }
        sbM.append("}}");
        return sbM.toString();
    }
}