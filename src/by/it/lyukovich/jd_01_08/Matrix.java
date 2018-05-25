package by.it.lyukovich.jd_01_08;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
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
    public Var add(Var other){
        if(other instanceof Scalar){
            double scalarValue = ((Scalar)other).getValue();
            double[][] res= Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]+=scalarValue;
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] =res[i][j]+((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res= this.value.clone();
            double scalarValue = ((Scalar)other).getValue();
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]-scalarValue;
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){

                double[][] res= this.value.clone();
                for (int i = 0; i < this.value.length; i++) {
                    res[i]=this.value[i].clone();
                }                for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]-((Matrix) other).value[i][j];
                }
            }
                return new Matrix(res);
            }
            else return super.sub(other);

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res= this.value.clone();
            double scalarValue = ((Scalar)other).getValue();
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]*scalarValue;
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector) {
            double[] res= ((Vector) other).value.clone();
                for (int i = 0; i < this.value.length; i++) {
                    double sum = 0.0;
                    for (int j = 0; j < this.value[0].length; j++) {
                        sum = sum + this.value[i][j] * ((Vector) other).value[j];
                    }
                    res[i] = sum;
                }
                return new Vector(res);
        }
        else if (other instanceof Matrix){
            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
            int size = this.value.length;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < size; k++) {
                        sum = sum + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                    res[i][j] = sum;
                }
            }
                return new Matrix(res);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] res= this.value.clone();
            double scalarValue = ((Scalar)other).getValue();
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]/scalarValue;
                }
            }
            return new Matrix(res);
        }
        else
            return super.div(other);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                if (j == value[0].length - 1) sb.append(value[i][j]);
                else {
                    sb.append(value[i][j]);
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i < value.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}
