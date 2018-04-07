package by.it.romankov.jd01_07;

public class Scalar extends AbstractVar {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String str) {
        value = Double.parseDouble(str);

    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;

    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
