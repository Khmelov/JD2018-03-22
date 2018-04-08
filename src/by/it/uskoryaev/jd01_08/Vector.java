package by.it.uskoryaev.jd01_08;


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
            double [] res = Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] += v;
            }
            return new Vector(res);
        }else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }
}
