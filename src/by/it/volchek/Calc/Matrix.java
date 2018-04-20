package by.it.volchek.Calc;

/**
 * Created by volchek on 05.04.18.
 */
public class Matrix extends Var {
    private double[][] value;

    Matrix(Matrix mtrx) {
        this.value = mtrx.value;
    }

    Matrix(double[][] mtrxMas) {
        this.value = mtrxMas;
    }

    Matrix(String matrixString) {
        String s = matrixString.substring(1, matrixString.length() - 1);
        s = s.replaceAll("\\s+","");
        String[] strMas = s.split("},");
        for (int i = 0; i < strMas.length; i++) {
            if (i == strMas.length - 1) strMas[i] = strMas[i].substring(1, strMas[i].length() - 1);
            else
                strMas[i] = strMas[i].substring(1, strMas[i].length());

        }
        String[] rowNumber = strMas[0].split(",");
        value = new double[strMas.length][rowNumber.length];
        for (int i = 0; i < strMas.length; i++) {
            String[] s1 = strMas[i].split(",");
            for (int j = 0; j < s1.length; j++) {
                value[i][j] = Double.parseDouble(s1[j]);
            }

        }


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

    @Override
    public Var add(Var other) throws CalcException {

            if (other instanceof Scalar) {
                double[][] res = this.value.clone();
                for (int i = 0; i < this.value.length; i++) {
                    res[i] = this.value[i].clone();
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] + ((Scalar) other).getValue();
                    }
                }
                return new Matrix(res);

            }




        else if (other instanceof Matrix){
            if ((this.value.length==((Matrix) other).value.length)&&(this.value[0].length==((Matrix) other).value[0].length))
            {
                double[][] res= this.value.clone();
                for (int i = 0; i < this.value.length; i++) {
                    res[i]=this.value[i].clone();
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j]=res[i][j]+((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
            else return super.add(other);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res= this.value.clone();
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]-((Scalar)other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){
            if ((this.value.length==((Matrix) other).value.length)&&(this.value[0].length==((Matrix) other).value[0].length))
            {
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
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res= this.value.clone();
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]*((Scalar)other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).getValue().length) {
                // double[][] res= Arrays.copyOf(value,value.length);
                double[] res= ((Vector) other).getValue().clone();

                double sum = 0.0;
                for (int i = 0; i < this.value.length; i++) {
                    sum = 0.0;
                    for (int j = 0; j < this.value[0].length; j++) {
                        sum = sum + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                    res[i] = sum;
                }
                return new Vector(res);
            }
            return super.mul(other);
        }
        else if (other instanceof Matrix){
            if ((this.value.length==((Matrix) other).value[0].length)&&(this.value[0].length==((Matrix) other).value.length))
            return new Matrix(mult(this.value,((Matrix) other).value));
            else return super.mul(other);

            }
            else return super.mul(other);
        }


    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res= this.value.clone();
            for (int i = 0; i < this.value.length; i++) {
                res[i]=this.value[i].clone();
            }            for (int i = 0; i < res.length; i++) {
                try{
                    if (((Scalar)other).getValue()==0) throw new ArithmeticException();
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j]=res[i][j]/((Scalar)other).getValue();
                }
                }
                catch (ArithmeticException e){
                    System.out.println("Попытка разделить матрицу на ноль!");
                    System.out.println(e.getClass()+e.getMessage()+e.getStackTrace());
                }
            }
            return new Matrix(res);
        }
        else
            return super.div(other);
    }
    public static double[][] mult(double[][] matrixLeft, double[][] matrixRight) throws CalcException {


            double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
            int size = matrixRight.length;
            double sum = 0;
        try {
            if (!(matrixLeft.length == matrixRight[0].length) && (matrixLeft[0].length == matrixRight.length))
                throw new CalcException();
        }
        catch (CalcException e){
            System.out.println("Матрицы с такими размерами нельзя перемножить"+e.getMessage());
        }


            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[0].length; j++) {
                    for (int k = 0; k < size; k++) {
                        sum = sum + matrixLeft[i][k] * matrixRight[k][j];
                    }
                    resultMatrix[i][j] = sum;
                    sum = 0;


                }

            }
            return resultMatrix;



    }
}
