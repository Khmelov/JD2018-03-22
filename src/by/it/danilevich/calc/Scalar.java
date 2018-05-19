package by.it.danilevich.calc;

import java.io.IOException;

public class Scalar extends Var {
    private double value;
    Scalar(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var sub(Var other) throws IOException {
        if (other instanceof Scalar) {
        double rez = (this.value - ((Scalar) other).value);
        Util.putToFileUserAction(this+"-"+other,String.valueOf(rez),false);
        return (new Scalar(rez));
    }
    else return null;

    }

    @Override
    public Var mul(Var other) throws CallException, IOException {
        if (other instanceof Scalar) {
        double rez = (this.value * ((Scalar) other).value);
        Util.putToFileUserAction(this+"*"+other,String.valueOf(rez),false);
        return (new Scalar(rez));
    }
    else return other.mul(this);

    }

    @Override
    public Var div(Var other) throws CallException, IOException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value!=0) {
                double z = ((Scalar) other).value;

                double rez = (this.value / z);
                Util.putToFileUserAction(this+"/"+other,String.valueOf(rez),false);

                return (new Scalar(rez));
            }
            else {
                Util.putToFileUserAction(this+"/"+other,Util.getError(Err.div0),true);
                throw new CallException(Util.getError(Err.div0));
            }
        }
        else{
            Util.putToFileUserAction(this+"/"+other,Util.getError(Err.falseDivScalar),true);
            throw new CallException(Util.getError(Err.falseDivScalar));
        }
    }

    @Override
    public Var add(Var other) throws CallException, IOException {
        if (other instanceof Scalar) {
            double rez = (this.value + ((Scalar) other).value);
            Util.putToFileUserAction(this+"+"+other,String.valueOf(rez),false);
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
