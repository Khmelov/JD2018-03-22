package by.it.danilevich.calc;


public class Matrix extends Var {
    private double[][] value;
    Matrix(double[ ][ ]  value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    public double[][] getValue() {
        return value;
    }

    Matrix(String strMatrix){
        String[] tempArr = strMatrix.split("},");
        int countColumn = 0;
        //
        if (tempArr.length !=0) {
            String tempS = tempArr[0].replaceAll("\\{}", "");
            //tempS = tempS.replaceAll("\\}", "");
            String[] temp = tempS.split(",");
            countColumn = temp.length;
            //tempS = "{" + tempS + "}";
        }

        double[][] arr = new double[tempArr.length][countColumn];
        for (int i = 0; i < tempArr.length; i++) {
            String tempS = tempArr[i].replaceAll("\\{}", "");
            //  tempS = tempS.replaceAll("\\}", "");
            tempS = "{" + tempS + "}";
            Vector v = new Vector(tempS);
            arr[i] = v.getValue();
        }
        this.value = arr;


    }
    @Override
    public String toString(){
        String rez ="", symbBegin = "{", symbEnd="}";
        int lastString = value.length;
        //int lastColumn = value[lastString-1].length;
        rez = rez + symbBegin;
        for (int i = 0; i < lastString; i++) {
            rez = rez .concat(symbBegin);
            for (int j = 0; j < (value[i].length -1); j++) {
                rez = rez.concat(Double.toString(value[i][j])) +", ";
            }
            if (i==(lastString-1) ) rez = rez + Double.toString(value[i][value[i].length-1])+ symbEnd;
            else rez = rez + Double.toString(value[i][value[i].length-1])+ symbEnd+", ";
        }
        rez = rez + symbEnd;

        return rez;
    }

    @Override
    public Var mul(Var other) throws CallException {
        if (other instanceof Matrix){
            if (!checkMatrixForMult(this.value,((Matrix) other).value)) throw new CallException("Размеры матриц не подходят для умножения");
            double[][] rez = ActionMatrix.mul( this.value, ((Matrix) other).value);
            return  (new Matrix(rez));
        }
        else if (other instanceof Vector){
            if (!checkMatrixVectorForMult(this.value,((Vector) other).getValue())) throw new CallException("Размеры матриц и вектора не подходят для умножения");

            double[] rez = ActionMatrix.mul( this.value, ((Vector) other).getValue());
            return  (new Vector(rez));
        }
        else if (other instanceof Scalar){
            double[][] rez = ActionMatrix.mul( ((Scalar) other).getValue(),this.value);
            return  (new Matrix(rez));
        }
        else return other.mul(this);
    }

    @Override
    public Var add(Var other) throws CallException {
        if (other instanceof Matrix){
            if (!compareMatrix(this.value,((Matrix) other).value)) throw new CallException("Размеры матриц не подходят для сложения");

            double[][] rez = ActionMatrix.add(this.value, ((Matrix) other).value);
            return (new Matrix(rez));
        }
        else if (other instanceof Scalar){
            double[][] rez = ActionMatrix.add(this.value, ((Scalar) other).getValue());
            return (new Matrix(rez));
        }
        else throw new CallException("Сложение невозможно");

    }

    @Override
    public Var sub(Var other) throws CallException {
        if (other instanceof Matrix){
            if (!checkMatrixForMult(this.value,((Matrix) other).value)) throw new CallException("Размеры матриц не подходят для вычитания");
            double[][] rez = ActionMatrix.sub(this.value, ((Matrix) other).value);
            return (new Matrix(rez));
        }
        else if (other instanceof Scalar){
            double[][] rez = ActionMatrix.sub(this.value, ((Scalar) other).getValue());
            return (new Matrix(rez));
        }
        else return other.mul(this);
    }

    private static boolean checkMatrixForMult(double[][] matrixLeft, double[][] matrixRight){
        //count column in Matrix1== count line in Matrix2
        if (matrixLeft.length!=0 &&matrixRight.length!=0){
            if (matrixLeft[0].length==matrixRight.length) {
                return true;
            }
            else System.out.println("Count of column matrix left not equal count of line matrix right");
        }
        else  System.out.println("Empty matrix!");
        return false;
    }
    private static boolean checkMatrixVectorForMult(double[][] matrixLeft, double[] vector){
        //count column in Matrix1== count line in Matrix2
        if (matrixLeft.length!=0 &&vector.length!=0){
            if (matrixLeft[0].length==vector.length) {
                return true;
            }
            else System.out.println("Count of column matrix left not equal count of line matrix right");
        }
        else  System.out.println("Empty matrix!");
        return false;

    }

    private static boolean compareMatrix(double[][] matrixLeft, double[][] matrixRight) {
        //count column in Matrix1== count line in Matrix2
        if (matrixLeft.length != 0 && matrixRight.length != 0) {
            if (matrixLeft[0].length == matrixRight[0].length) {
                return true;
            } else System.out.println("Count of column matrix left not equal count of line matrix right");
        } else System.out.println("Empty matrix!");
        return false;
    }
}
