package by.it.shekh.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    Vector(double... value) {
        this.value = value;
    }

    Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    Vector(String line) {
        String str = line.substring(1, line.length() - 1);
        String[] strMas = str.trim().split(",");
        double[] value = new double[strMas.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strMas[i]);
        }
        this.value = value;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Vector vector = ((Vector) other);
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += vector.value[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Vector vector = ((Vector) other);
            double []res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i <res.length ; i++) {
                res[i]-=vector.value[i];
            }
            return new Vector(res);
    } else return super.sub(other);
}

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double mult=0;
            Vector vector = ((Vector) other);
            double []res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i <res.length ; i++) {
                mult+=res[i]*vector.value[i];
            }
            return new Scalar(mult);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = ((Scalar) other);
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= v;
            }
            return new Vector(res);
        }
        else return super.div(other);
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < value.length; i++) {
            s += Double.toString(value[i]);
            if (i != value.length - 1) s += ", ";
        }
        s += "}";
        return s;
    }

    public double[] getValue() {
        return value;
    }
}
