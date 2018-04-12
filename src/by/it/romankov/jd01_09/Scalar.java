package by.it.romankov.jd01_09;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double vv) {
        this.value = vv;
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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = value + ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return other.add(this);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = value - ((Scalar) other).value;
            return new Scalar(sub);
        } else
        return new Scalar(-1).mul(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {

            double mul = value * ((Scalar) other).value;
            return new Scalar(mul);
        }else
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = value / ((Scalar) other).value;
            return new Scalar(div);
        }else
        return other.div(this);
    }
    }
