package by.it.uskoryaev.calc;


import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public String toString() {
        StringBuilder rex = new StringBuilder();
        for (double i : value) {
            rex.append(Double.toString(i)).append(", ");
        }

        return "{" + rex.toString().replaceAll(", $", "") + "}";
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] str = strVector.substring(1, strVector.length() - 1).split(",");
        value = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] += v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] -= v;
            }
            return new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] -= ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double [] res = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] *= v;
            }
            return new Vector(res);
        }else if (other instanceof Vector){
            double resultEnd = 0;
            Vector vector = (Vector)other;
            double [] res = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i <res.length ; i++) {
                resultEnd += res[i]*vector.value[i];
            }
            return new Scalar(resultEnd);
        }else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar)other;
            double v = scalar.getValue();
            double [] res = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i <res.length ; i++) {
                res[i] = res[i]/v;
            }
            return new Vector(res);
        }
        return super.div(other);
    }
}

