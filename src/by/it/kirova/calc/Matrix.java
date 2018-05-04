package by.it.kirova.calc;


public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(2, strMatrix.length() - 2);
        String[] row = strMatrix.split("},( *)\\{");

        for (int i = 0; i < row.length; i++) {
            String[] strValues = row[i].split(",( *)");
            if (value == null)
                value = new double[row.length][strValues.length];
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(strValues[j]);
            }
        }
    }

    @Override
    public Var add(Var other)throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sum[i], 0, this.value[i].length);
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j] += v;
                }
            }
            return new Matrix(sum);
        } else if (other instanceof Matrix) {
            double[][] sum = new double[this.value.length][this.value[0].length];
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException("Матрицы имеют разную размерность. Операция сложения невозможна");
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sum[i], 0, this.value[i].length);
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sum);
        } else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sub[i], 0, this.value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] -= v;
                }
            }
            return new Matrix(sub);
        } else if (other instanceof Matrix) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException("Матрицы имеют разную размерность. Операция вычитания невозможна");
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, sub[i], 0, this.value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        } else
            return super.sub(other);

    }

    @Override
    public Var mul(Var other)throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, mul[i], 0, this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[i].length; j++) {
                    mul[i][j] *= v;
                }
            }
            return new Matrix(mul);
        } else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] v = vector.getValue();
            double[] mulVector = new double[v.length];
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, mul[i], 0, this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < v.length; j++) {
                    mulVector[i] += mul[i][j] * v[j];
                }
            }
            return new Vector(mulVector);
        } else {
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException("Матрицы имеют разную размерность. Операция умножения невозможна");
            double[][] mul = new double[this.value.length][this.value[0].length];
            double[][] mulMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, mul[i], 0, this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    for (int k = 0; k < mul[i].length; k++) {
                        mulMatrix[i][j] += mul[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mulMatrix);
        }

    }


    @Override
    public Var div(Var other)throws CalcException{
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] div = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, div[i], 0, this.value[i].length);
            }
            if (v == 0)
                throw new CalcException("Деление на ноль");
            for (int i = 0; i < div.length; i++) {
                for (int j = 0; j < div[i].length; j++) {
                    div[i][j] /= v;
                }
            }
            return new Matrix(div);
        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < value.length - 1; i++) {
            rowToString_Impl(sb, i);
            sb.append(", ");
        }
        rowToString_Impl(sb, i);
        return "{" + sb.toString() + "}";

    }


    private void rowToString_Impl(StringBuilder sb, int i) {
        sb.append("{");
        for (int j = 0; j < value[i].length - 1; j++) {
            sb.append(value[i][j]).append(", ");
        }

        sb.append(value[i][value[i].length - 1]).append("}");
    }
}

