package by.it.kirova.jd01_07;


public class Vector extends AbstractVar {

    private double[] array;

    Vector(double[] value) {
        this.array = value;
    }

    Vector(Vector vector) {
        this.array = vector.array;

    }

    Vector(String strVector) {
        String[] s = strVector.substring(1, strVector.length() - 1).split(",");
        array = new double[s.length];
        for (int i = 0; i <s.length ; i++) {
            array[i] = Double.parseDouble(s[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <array.length-1 ; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[array.length-1]);
        return "{" + sb.toString() + "}";

    }
}
