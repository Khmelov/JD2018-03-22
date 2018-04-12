package by.it.romankov.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;


    public Vector(double[] v) {
        value = v;
    }

    public Vector(Vector vector) {
        value = vector.value;
    }

    public Vector(String strVector) {
        String[] s = strVector.replace("{", "").replaceAll("}", "").split(",");
        value = new double[s.length];
        System.out.print("{");
        for ( int i = 0; i < s.length; i++ ) {
            value[i] = Double.parseDouble(s[i]);
            if (i == s.length - 1) {
                System.out.print(value[i]);
            } else System.out.print(value[i] + ", ");
        }
        System.out.print("}");
    }


    @Override
    public String toString() {
        return Arrays.toString(value).replace('[', '{').replace(']', '}');

    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }

        return super.add(other);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }

        return super.sub(other);

    }


    @Override
    public Var mul(Var other) {
        double sum = 0;
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                sum += (res[i] * ((Vector) other).value[i]);
            }
            return new Scalar(sum);
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {

        if (other instanceof Vector) {
            return super.div(other);
        } else if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for ( int i = 0; i < res.length; i++ ) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);


        }
        return super.div(other);

    }
}
