package by.it.romankov.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar {
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
            if(i==s.length-1)
            {
                System.out.print(value[i]);
            }
            else System.out.print(value[i] + ", ");
        }
        System.out.print("}");
    }


    @Override
    public String toString() {
        return Arrays.toString(value).replace('[', '{').replace(']', '}');

    }


}
