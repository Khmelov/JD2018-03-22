package by.it.akhmelev.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value=new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(String strValue) {
        String[] sArray=strValue
                .replace('{',' ').replace('}',' ')
                .trim().split(",\\s*");
        value=new double[sArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(sArray[i]);
        }
    }

    Vector(Vector varScalar){
        this(varScalar.value);
    }


    @Override
    public Var add(Var otherVar) {
        if (otherVar instanceof Vector) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] += ((Vector) otherVar).value[i];
            return result;
        } else if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] += ((Scalar) otherVar).getValue();
            return result;
        } else
            return super.add(otherVar);

    }

    @Override
    public Var sub(Var otherVar) {
        if (otherVar instanceof Vector) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] -= ((Vector) otherVar).value[i];
            return result;
        } else if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] -= ((Scalar) otherVar).getValue();
            return result;
        } else
            return super.sub(otherVar);
    }

    @Override
    public Var mul(Var otherVar) {
        if (otherVar instanceof Vector) {
            double sum=0;
            for (int i = 0; i < this.value.length; i++)
                sum += this.value[i]*((Vector) otherVar).value[i];
            return new Scalar(sum);

        } else if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] *= ((Scalar) otherVar).getValue();
            return result;

        } else
            return super.add(otherVar);

    }

    @Override
    public Var div(Var otherVar) {
        if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] /= ((Scalar) otherVar).getValue();
            return result;
        } else
            return super.sub(otherVar);
    }
    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[','{')
                .replace(']','}');
    }
}
