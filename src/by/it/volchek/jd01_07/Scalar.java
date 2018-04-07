package by.it.volchek.jd01_07;

/**
 * Created by volchek on 05.04.18.
 */
public class Scalar extends AbstractVar {
    private double value;

    Scalar(double value) {
        this.value = value;

    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);

    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;

    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
