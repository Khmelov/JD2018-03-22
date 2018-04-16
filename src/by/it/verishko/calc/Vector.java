package by.it.verishko.calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] s = strVector.substring(1, strVector.length() - 1).split(",");
        value = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] add = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] += v;
            }
            return new Vector(add);
        } else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += vector.value[i];
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
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= v;
            }
            return new Vector(sub);
        } else if (other instanceof Vector) {
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] mul = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= v;
            }
            return new Vector(mul);
        } else if (other instanceof Vector) {
            double[] mul = Arrays.copyOf(this.value, this.value.length);
            double sum = 0;
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= ((Vector) other).value[i];
                sum += mul[i];
            }
            return new Scalar(sum);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] div = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] /= v;
            }
            return new Vector(div);
        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double element : value) {
            sb.append(del).append(element);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    public double[] getValue() {
        return value;
    }
}