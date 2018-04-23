package by.it.sgolovach.calc;


class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    public Scalar(String str) {
        value = Double.parseDouble(str);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar res = new Scalar(this);
            res.value += ((Scalar) other).value;
            return res;
        } else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value - ((Scalar) other).value;
            return new Scalar(res);
        } else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double z = ((Scalar) other).value;
            if (z == 0)
                throw new CalcException("Деление на ноль");
            double div = this.value / z;
            return new Scalar(div);
        }
        return super.div(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
