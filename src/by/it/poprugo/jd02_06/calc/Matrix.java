package by.it.poprugo.jd02_06.calc;

import java.util.Arrays;

public class Matrix extends Var {
    double[][] arrTwoDim;

    Matrix(double[][] arrTwoDim) {
        this.arrTwoDim = arrTwoDim;
    }

    Matrix(Matrix matrix) {
        this.arrTwoDim = matrix.arrTwoDim;
    }

    Matrix(String strMatrix) {
        String[] strRow = strMatrix.trim().split("}, *\\{");
        arrTwoDim = new double[strRow.length][];
        for (int i = 0; i < strRow.length; i++) {
            String[] strCol = strRow[i].replaceAll("[{}]", " ")
                    .trim().split(",\\s*");
            arrTwoDim[i] = new double[strCol.length];
            for (int j = 0; j < strCol.length; j++) {
                arrTwoDim[i][j] = Double.parseDouble(strCol[j]);
            }
        }
        /*arrOneDim = new double[sArray.length];
        for (int i = 0; i < arrOneDim.length; i++) {
            arrOneDim[i] = Double.parseDouble(sArray[i]);
        }*/
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] resA = new double[this.arrTwoDim.length][];
            for (int i = 0; i < resA.length; i++) {
                resA[i] = Arrays.copyOf(this.arrTwoDim[i], this.arrTwoDim[i].length);
            }
            for (int i = 0; i < resA.length; i++) {
                for (int j = 0; j < resA[i].length; j++) {
                    resA[i][j] += scalar.getValue();
                }
            }
            return new Matrix(resA);
        } else if (other instanceof Vector)
            return super.add(other);
        else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            if ((arrTwoDim.length == (matrix.arrTwoDim.length))
                    && (arrTwoDim[0].length == (matrix.arrTwoDim[0].length))) {
                double[][] resA = new double[this.arrTwoDim.length][];
                for (int i = 0; i < resA.length; i++) {
                    resA[i] = Arrays.copyOf(this.arrTwoDim[i], this.arrTwoDim[i].length);
                }
                for (int i = 0; i < resA.length; i++) {
                    for (int j = 0; j < resA[i].length; j++) {
                        resA[i][j] += matrix.arrTwoDim[i][j];
                    }
                }
                return new Matrix(resA);
            } else {
                System.out.println("Different size matrix's adding is impossible");
                return super.add(other);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] resS = new double[this.arrTwoDim.length][];
            for (int i = 0; i < resS.length; i++) {
                resS[i] = Arrays.copyOf(this.arrTwoDim[i], this.arrTwoDim[i].length);
            }
            for (int i = 0; i < resS.length; i++) {
                for (int j = 0; j < resS[i].length; j++) {
                    resS[i][j] -= scalar.getValue();
                }
            }
            return new Matrix(resS);
        } else if (other instanceof Vector)
            return super.sub(other);
        else if (other instanceof Matrix) return this.add(other.mul(new Scalar(-1.0)));
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] resM = new double[this.arrTwoDim.length][];
            for (int i = 0; i < resM.length; i++) {
                resM[i] = Arrays.copyOf(this.arrTwoDim[i], this.arrTwoDim[i].length);
            }
            for (int i = 0; i < resM.length; i++) {
                for (int j = 0; j < resM[i].length; j++) {
                    resM[i][j] *= scalar.getValue();
                }
            }
            return new Matrix(resM);
        } else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            if ((this.arrTwoDim[0].length)==(vector.getValue().length)) {
                double[] resM = new double[vector.getValue().length];
                for (int i = 0; i < resM.length; i++) {
                    for (int j = 0; j < resM.length; j++) {
                        resM[i] += this.arrTwoDim[i][j] * vector.getValue()[j];
                    }
                }
                return new Vector(resM);
            } else {
                System.out.println("Different control sizes. Multiplying is impossible.");
                return super.mul(other);
            }
        } else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            if ((this.arrTwoDim[0].length)==(matrix.arrTwoDim.length)) {
                double[][] resM = new double[this.arrTwoDim.length][matrix.arrTwoDim.length];
                for (int i = 0; i < resM.length; i++) {
                    for (int j = 0; j < resM[i].length; j++) {
                        for (int k = 0; k < resM[i].length; k++) {
                            resM[i][j] += this.arrTwoDim[i][k] * matrix.arrTwoDim[k][j];
                        }
                    }
                } return new Matrix(resM);
            } else {
                System.out.println("Different control sizes. Multiplying is impossible.");
                return super.mul(other);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    /*@Override
        public String toString() {
            StringBuilder sbM = new StringBuilder("{{");
            String signBoundRow = "";
            for (int i = 0; i < arrTwoDim.length; i++) {
                for (int j = 0; j < arrTwoDim[i].length; j++) {
                    sbM.append(signBoundRow).append(arrTwoDim[i][j]);
                    if (j < arrTwoDim[i].length - 1) signBoundRow = ", ";
                    else signBoundRow = "}, {";
                }
            }
            sbM.append("}}");
            return sbM.toString();
        }*/
    @Override
    public String toString() {
        String[] rows = new String[arrTwoDim.length];

        for (int i = 0; i < arrTwoDim.length; i++) {
            rows[i] = Arrays.toString(arrTwoDim[i]);
        }

        return Arrays.toString(rows)
                .replace('[', '{')
                .replace(']', '}');
    }
}
