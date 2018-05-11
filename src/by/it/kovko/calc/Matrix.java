package by.it.kovko.calc;

import java.util.Arrays;

public class Matrix extends Var {
    private double value[][];

    Matrix(){}

    Matrix(double [][] value){
        this.value = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i],value[i].length);
        }
    }

    Matrix (Matrix matrix){
        this.value = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            this.value[i] = Arrays.copyOf(matrix.value[i],matrix.value[i].length);
        }
    }

    Matrix(String strMatrix){
        strMatrix=strMatrix.replaceAll("[{]+","")+"},";
        String lines[] = strMatrix.split("[}]+,");
        value = new double[lines.length][];
        String line[];
        for (int i = 0; i < lines.length; i++) {
            line=lines[i].split(",");
            value[i]=new double[line.length];
            for (int j = 0; j < line.length; j++) {
                value[i][j]=Double.parseDouble(line[j]);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            result.append("{").append(Arrays.toString(value[i]).replaceAll("[\\[\\]]","")).append("}");
            if (i<value.length-1)
                result.append(", ");
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double result[][]= new double [this.value.length][];
            for (int i = 0; i < this.value.length; i++)
                result[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            double s=((Scalar)other).getValue();
            for (double[] line : result)
                for (int i = 0; i < line.length; i++)
                    line[i]+=s;
            return new Matrix(result);
        } else if (other instanceof Matrix){
            if (this.value.length!=(((Matrix) other).value.length) || this.value[0].length!=(((Matrix) other).value[0].length))
                throw new CalcException("Матрицы разной длины");
            double result[][]= new double [this.value.length][];
            for (int i = 0; i < this.value.length; i++){
                result[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
                for (int i = 0; i < result.length; i++)
                    for (int j = 0; j < result[i].length; j++)
                        result [i][j]+=(((Matrix) other).value[i][j]);
            return new Matrix(result);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            return this.add(other.mul(new Scalar(-1)));
        } else if (other instanceof Matrix){
            return this.add(other.mul(new Scalar(-1)));
        } else
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double s=((Scalar) other).getValue();
            double result[][]= new double [this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < result.length; i++)
                for (int j = 0; j < result[i].length; j++)
                    result [i][j]*=s;
            return new Matrix(result);
        } else if (other instanceof Vector){
            double result[] = new double[((Vector) other).getValue().length];
            try {
                for (int i = 0; i < this.value.length; i++)
                    for (int j = 0; j < result.length; j++)
                        result[i] += (this.value[i][j] * ((Vector) other).getValue()[j]);
            } catch (IndexOutOfBoundsException e){
                super.mul(other);
            }
            return new Vector(result);
        } else if (other instanceof Matrix){
            if (this.value[0].length!=(((Matrix) other).value.length))
                throw new CalcException("Матрицы разной длины");
            double result[][] = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < result.length; i++)
                for (int j = 0; j < result[i].length; j++) {
                    for (int k = 0; k < result[i].length; k++)
                        result[i][j] += (this.value[i][k] * ((Matrix) other).value[k][j]);
                    //System.out.println(result[i][j]);
                }
                return new Matrix(result);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }
}
