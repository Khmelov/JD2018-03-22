package by.it.shekh.jd01_07;

class Scalar extends AbstractVar {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        value = Double.parseDouble(str);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    void sss() {
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
