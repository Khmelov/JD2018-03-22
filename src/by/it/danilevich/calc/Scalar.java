package by.it.danilevich.calc;

public class Scalar extends Var {
    private double value;
    Scalar(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var sub(Var other) throws CallException {
        if (other instanceof Scalar) {
        double rez = (this.value - ((Scalar) other).value);
        return (new Scalar(rez));
    }
    else return null;

    }

    @Override
    public Var mul(Var other) throws CallException {
        if (other instanceof Scalar) {
        double rez = (this.value * ((Scalar) other).value);
        return (new Scalar(rez));
    }
    else return other.mul(this);

    }

    @Override
    public Var div(Var other) throws CallException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value!=0) {
                double z = ((Scalar) other).value;

                double rez = (this.value / z);
                return (new Scalar(rez));
            }
            else throw new CallException("Деление на 0 невозможен");
        }
        else throw new CallException("На скаляр можно делить только число");
    }

    @Override
    public Var add(Var other) throws CallException {
        if (other instanceof Scalar) {
            double rez = (this.value + ((Scalar) other).value);
            return (new Scalar(rez));
        }
        else return other.add(this);
    }

    public Scalar(String str){
        this.value = Double.parseDouble(str);
    }

    public Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }
    @Override
    public String toString(){
        return Double.toString(value);
    }
}
