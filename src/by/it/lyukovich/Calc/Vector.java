package by.it.lyukovich.Calc;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Vector extends Var {
    protected double[] value;
    Vector(double[] value){
        this.value= Arrays.copyOf(value,value.length);
    }
    Vector(Vector vector){
        this.value=vector.value;
    }
    Vector(String strVector){
        String strValues[]=strVector.replaceAll("[{}]","").split(",");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }
    @Override
    public Var add(Var other){
        if(other instanceof Scalar){
            Scalar scalar = (Scalar)other;
            double v=scalar.getValue();
            double[] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=v;
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            Vector vector = (Vector)other;
            double[] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.add(other);
    }
    @Override
    public Var sub(Var other){
        if(other instanceof Scalar){
            Scalar scalar = (Scalar)other;
            double v=scalar.getValue();
            double[] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=v;
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            Vector vector = (Vector)other;
            double[] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.sub(other);
    }
    @Override
    public Var mul(Var other){
        if(other instanceof Scalar){
            Scalar scalar = (Scalar)other;
            double v=scalar.getValue();
            double[] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]*=v;
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            Vector vector = (Vector)other;
            double[] res=Arrays.copyOf(this.value,this.value.length);
            double mulres=0;
            for (int i = 0; i < res.length; i++) {
                res[i]*=((Vector) other).value[i];
                mulres+=res[i];
            }
            return new Scalar(mulres);
        }
        else
            return super.mul(other);
    }
    @Override
    public Var div(Var other){
        if(other instanceof Scalar){
            Scalar scalar = (Scalar)other;
            double v=scalar.getValue();
            double[] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]*=1/v;
            }
            return new Vector(res);
        }
         else
            return super.div(other);
    }

    @Override
    public String toString() {
        return "{"+Arrays.toString(value).replaceAll("[\\[\\]]","")+"}";
    }

}
