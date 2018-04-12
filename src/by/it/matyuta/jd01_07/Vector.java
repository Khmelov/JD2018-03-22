package by.it.matyuta.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(String strValue) {
        String[] sArray = strValue
                .replace('{', ' ').replace('}', ' ')
                .trim().split(",\\s*");
        value = new double[sArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(sArray[i]);
        }
    }

    Vector(Vector varScalar) {
        this(varScalar.value);
    }


    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}
