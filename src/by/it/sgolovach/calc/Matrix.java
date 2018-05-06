package by.it.sgolovach.calc;


class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }

    public Matrix(Matrix otherMatrix) {
        this(otherMatrix.value);
    }

    public Matrix(String matrix) {
        String[] str = matrix.split("[^0-9]+");
        char[] ch = matrix.toCharArray();
        int a = 0;
        for (char c : ch) {
            if (c == '{') a++;
        }
        value = new double[a - 1][(str.length - 1) / (a - 1)];

        int col = (str.length - 1) / (a - 1), strn = 1;

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < col; j++) {
                value[i][j] = Double.parseDouble(str[strn]);
                strn++;
            }

        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] + v;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] res = new double[this.value.length][this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] - v;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] res = new double[this.value.length][this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else return super.sub(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] * v;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] v = vector.getValue();
            double[] res = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < v.length; j++) {
                    res[i] = res[i] + this.value[i][j] * v[j];
                }
            }
            return new Vector(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        res[i][j] = res[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(res);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] res = new double[this.value.length][this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = this.value[i][j] / v;
                }
            }
            return new Matrix(res);
        } else return super.div(other);
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
