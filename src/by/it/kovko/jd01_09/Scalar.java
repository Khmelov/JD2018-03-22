package by.it.kovko.jd01_09;


class Scalar extends Var {
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
    public Var add(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar)
            return this.add(new Scalar(-1).mul(other));
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        try{
            if (other instanceof Scalar)
                return this.mul(new Scalar(1/((Scalar) other).getValue()));
        } catch (ArithmeticException e) {
            System.out.println("Деление на нулевой скаляр");
            return null;
        }
        return super.div(other);
    }
}
