package by.it.kovko.calc;


class Scalar extends Var {
    //Logger logger = Logger.getLogger();
    private double value;
    Scalar(){}
    Scalar(double value){
        this.value=value;
    }
    Scalar(Scalar scalar){
        this.value=scalar.value;
    }
    Scalar(String strScalar){
        value=Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar)
            return this.add(new Scalar(-1).mul(other));
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double z = ((Scalar) other).getValue();
            if (z == 0) {
                //logger.toLog(Errors.DIVISION_BY_ZERO.toString());
                throw new CalcException(Errors.DIVISION_BY_ZERO.toString());
            }
            else
                return this.mul(new Scalar(1 / ((Scalar) other).getValue()));
        }
        return super.div(other);
    }
}
