package by.it.kovko.calc;

import java.util.Arrays;

public class Vector extends Var {
    private double value[];
    public double[] getValue() {
        return value;
    }
    Vector() {
    }
    Vector(double[] value){
        this.value= Arrays.copyOf(value,value.length);
    }
    Vector(Vector vector){
        this.value=vector.value;
    }

    Vector(String strVector){
        String strValues[];
        strValues=strVector.replaceAll("[{}]","").split(",");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double s = ((Scalar) other).getValue();
            double result[] = Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < result.length; i++)
                result[i]+=s;
            return new Vector(result);
        } else if (other instanceof Vector){
            double result[] = Arrays.copyOf(this.value, this.value.length);
            try{
                for (int i = 0; i < result.length; i++)
                    result [i]+=((Vector)other).value[i];
            } catch (IndexOutOfBoundsException e){
                System.out.println("Вектора разной длины");
                return null;
            }
            return new Vector(result);
        } else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return this.add(other.mul(new Scalar(-1)));
        } else if (other instanceof Vector){
            return this.add(other.mul(new Scalar(-1)));
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double s = ((Scalar) other).getValue();
            double result[] = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++)
                result [i]*=s;
            return new Vector(result);
        } else if (other instanceof Vector){
            double result=0;
            try {
                for (int i = 0; i < this.value.length; i++)
                    result +=(this.value[i]*((Vector)other).value[i]);
            } catch (IndexOutOfBoundsException e){
                System.out.println("Вектора разной длины");
                return null;
            }
            return new Scalar(result);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            try{
                return this.mul(new Scalar(1/((Scalar) other).getValue()));
            } catch (ArithmeticException e) {
                System.out.println("Деление на нулевой скаляр");
                return null;
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return "{"+Arrays.toString(value).replaceAll("[\\[\\]]","")+"}";
    }
}
