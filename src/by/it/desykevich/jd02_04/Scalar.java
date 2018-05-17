package by.it.desykevich.jd02_04;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar) other).value);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar) other).value);
        } else {
            Scalar minus = new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double v = ((Scalar) other).value;
            if (v == 0)
                throw new CalcException(" Деление на 0 ");
            else return new Scalar(this.value / ((Scalar) other).value);
        } else throw new CalcException(" Операция невозможна ");
    }


    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}