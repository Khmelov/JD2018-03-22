package by.it.shekh.jd01_08;

class Scalar extends Var {
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


    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double res = this.value + ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        return new Scalar(-1).mul(super.mul(other));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double res = this.value * ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double res = this.value / ((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
