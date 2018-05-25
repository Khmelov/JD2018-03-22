package by.it.lyukovich.Calc;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value){
        this.value=value;
    }
    public String toString(){
        return Double.toString(value);
    }
    public Scalar(String str){
        this.value = Double.parseDouble(str);
    }
    public Scalar(Scalar otherScalar){
        this.value=otherScalar.value;

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double res = this.value+((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double res = this.value-((Scalar) other).value;
            return new Scalar(res);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double res = this.value*((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double res = this.value/((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(this);
    }
}
