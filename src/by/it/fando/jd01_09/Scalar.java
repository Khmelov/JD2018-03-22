package by.it.fando.jd01_09;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }
    public Scalar (String str) {
        this.value=Double.parseDouble(str);
    }
    Scalar(Scalar varScalar) { this.value=varScalar.value; }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double add=this.value+((Scalar)other).value;
            return new Scalar(add);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub=this.value-((Scalar)other).value;
            return new Scalar(sub);
        }
        return new Scalar(-1).mul(other.sub(this));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul=this.value*((Scalar)other).value;
            return new Scalar(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div=this.value/((Scalar)other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    @Override
    public String toString () {
        return Double.toString(value);
    }
}
