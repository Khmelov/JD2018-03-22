package by.it.volchek.jd01_08;

import java.util.Arrays;

/**
 * Created by volchek on 05.04.18.
 */
 class Vector extends Var {
    private double[] value;
    public double[] getValue() {
        return value;
    }
   Vector(double[] var) {
        this.value = var;
    }
    Vector(String str) {
        String s = str.substring(1,str.length()-1);
        String[] strMas = s.split(",");
        this.value = new double[strMas.length];
        for (int i = 0; i <strMas.length ; i++) {
            value[i] = Double.parseDouble(strMas[i]);
        }
    }
   Vector(Vector vector) {
        this.value = vector.value;
    }
    @Override

    public String toString(){
        String s = Arrays.toString(this.value);
        s= s.replace('[','{');
        s=s.replace(']','}');
        return s;

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
            if (this.value.length==((Vector) other).value.length) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];
                }
                return new Vector(res);
            }
            else return super.add(other);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]-((Vector)other).value[i];
            }
            return new Vector(res);
            }
            else return super.sub(other);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]*((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value,value.length);
            double sum = 0.0;
            for (int i = 0; i < res.length; i++) {
                sum+=res[i]*((Vector)other).value[i];
            }
            return new Scalar(sum);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]/((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.div(other);
    }
}




