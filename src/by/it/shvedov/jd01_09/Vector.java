package by.it.shvedov.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value =new double [value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }


    Vector(String strVector ){
        String[] mas = strVector
                .replace('{',' ').replace('}',' ')
                .trim().split(",\\s");
        value=new double[mas.length];
        for (int i = 0; i <value.length ; i++) {
            value[i]=Double.parseDouble(mas[i]);
        }
    }
    Vector(Vector vector){
        this.value=vector.value;
    }



    @Override
    public Var add(Var other) {
        if( other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
            if(other instanceof Vector){
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];
                }
                return new Vector(res);
            }

        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        double sum=0;
        if( other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
                sum+=res[i];
            }
            return new Vector(String.valueOf(sum));
        }
        if(other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).value[i];
                sum+=res[i];
            }
            return new Vector(String.valueOf(sum));
        }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) {
        if( other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if(other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }

        return super.sub(other);
    }

    @Override
    public Var div(Var other) {
        if( other instanceof Scalar) {
            return super.div(other);
        }
        if(other instanceof Vector){
            return super.div(other);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimetr="";
        for (double element : value) {
            sb.append(delimetr).append(element);
            delimetr=", ";

        }
        sb.append("}");
        return sb.toString();

    }
}
