package by.it.sgolovach.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(String vector) {
        double[] value1 = new double[0];
        String[] str = vector.split("[^0-9]+");
        int a = 0;
        for (int i = 0; i < str.length; i++) {
            if (i != 0) {
                int last = value1.length;
                value1 = Arrays.copyOf(value1, last + 1);
                value1[last] = Double.parseDouble(str[i]);
            }
        }
        value = value1;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    private void chekSize(Var otherVar) throws CalcException {
        if (this.value.length != ((Vector) otherVar).value.length)
            throw new CalcException("Различный размер векторов");
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            chekSize((Vector)other);
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.add(other);

    }


    @Override
    public Var sub(Var other) throws CalcException {

        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            chekSize(other);
            Vector vector = (Vector) other;
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double sum = 0;
            chekSize(other);
            Vector vector = (Vector) other;
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                sum += res[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= v;
            }
            return new Vector(res);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        String str = new String();
        int a = 0;
        str = str + "{";
        for (double v : value) {
            a++;
            str = str + v;
            if (a < value.length) str = str + ", ";
        }

        str = str + "}";

        return str;
    }
}
