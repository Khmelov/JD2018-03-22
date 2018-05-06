package by.it.uskoryaev.calc;

class Scalar extends Var {

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

    @Override
    public Var add(Var other){
        if (other instanceof Scalar){
            double result = this.value+((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double result = this.value-((Scalar)other).value;
            return new Scalar(result);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double result = this.value * ((Scalar)other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (!other.equals(0)) {
                double result = this.value / ((Scalar) other).value;
                return new Scalar(result);
            }
            return other.div(this);
        }else{
            return super.div(other);
        }

    }


    public double getValue() {
        return value;
    }
}
