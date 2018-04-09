package by.it.fando.jd01_07;

class Scalar extends AbstractVar {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    public Scalar (String str) {
        this.value=Double.parseDouble(str);
    }

    Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }

    @Override
    public String toString () {
        return Double.toString(value);
    }
}
