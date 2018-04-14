package by.it.uskoryaev.jd01_07;

class Scalar extends AbstractVar {

    private double value;

    @Override
    public String toString() {
        return Double.toString(value);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        value = Double.parseDouble(str);

    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }
}
