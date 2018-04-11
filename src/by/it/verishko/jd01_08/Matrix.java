package by.it.verishko.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    private Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    Matrix(String line) {
        String str = line.substring(1, line.length() - 1);

        String[] masMas = str.split("},\\s*");
        for (int i = 0; i < masMas.length; i++) {
            if (i == masMas.length - 1)
                masMas[i] = masMas[i].substring(1, masMas[i].length() - 1);//Удаляем первую в каждом подмассиве и последнюю скобки
            else masMas[i] = masMas[i].substring(1, masMas[i].length());
        }

        String elemCol[] = masMas[0].split(",");
        value = new double[masMas.length][elemCol.length];
        for (int i = 0; i < masMas.length; i++) {
            String[] strr = masMas[i].split(",");
            for (int j = 0; j < strr.length; j++) {
                value[i][j] = Double.parseDouble(strr[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = v + this.value[i][j];
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = ((Matrix) other);
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = matrix.value[i][j] + this.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] - v;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = ((Matrix) other);
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] - matrix.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] * v;
                }
            }
            return new Matrix(res);

        } else if (other instanceof Vector) {
            Vector vector = ((Vector) other);
            double[] vect = vector.getValue();
            double[] res = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < vect.length; j++) {
                    res[i] += this.value[i][j] * vect[j];
                }
            }
            return new Vector(res);

        } else if (other instanceof Matrix) {
            Matrix matrix = ((Matrix) other);
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < matrix.value[0].length; j++) {
                    for (int k = 0; k < matrix.value.length; k++) {
                        res[i][j] = res[i][j] + this.value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] / v;
                }
            }
            return new Matrix(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < value.length; i++) {
            s += "{";
            for (int j = 0; j < value[0].length; j++) {
                s += Double.toString(value[i][j]);
                if (j != value[0].length - 1) s += ", ";
            }
            s += "}";
            if (i != value.length - 1) s += ", ";
        }
        s += "}";
        return s;
    }
}