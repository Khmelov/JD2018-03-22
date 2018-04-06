package by.it.sgolovach.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar {

    private double[] value;

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
        value=value1;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
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
