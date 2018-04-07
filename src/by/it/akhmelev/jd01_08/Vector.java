package by.it.akhmelev.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector)other).value[i];
            }
            return new Vector(res);
        }
        else
           return super.add(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[','{')
                .replace(']','}');
    }
}
