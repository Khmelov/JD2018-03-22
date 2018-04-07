package by.it.akhmelev.jd01_08;


import java.util.Arrays;

public class Vector extends Var {

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
            double[] res = Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length - 1; i++) {
            sb.append(value[i]).append(", ");
        }
        sb.append(value[value.length - 1]);
        return "{" + sb.toString() + "}";

    }
}
