package by.it.danilevich.jd01_08;

public class Scalar extends Var {
    private double value;
    Scalar(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
        double rez = (this.value - ((Scalar) other).value);
        return (new Scalar(rez));
    }
    else return other.add(this);

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
        double rez = (this.value * ((Scalar) other).value);
        return (new Scalar(rez));
    }
    else return other.add(this);

    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).value!=0) {
                double rez = (this.value / ((Scalar) other).value);
                return (new Scalar(rez));
            }
            else return null;
        }
        else return other.add(this);
    }

    @Override
    public Var add(Var other) {
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
