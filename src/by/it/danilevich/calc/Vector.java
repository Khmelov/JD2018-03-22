package by.it.danilevich.calc;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[ ] value){
        this.value = value;
    }
    Vector(Vector vector){
        this.value = vector.value;
    }
    Vector(String strVector){
        Pattern pattern  = Pattern.compile("([{}])");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()){
            strVector = matcher.replaceAll( " ");
        }

        String[] num = strVector.split(",");
        double[] arr = new double[num.length];
        for (int i = 0; i < num.length; i++) {
            String symbol = String.valueOf(num[i]);
            arr[i] = Double.parseDouble(symbol);
        }
        this.value = arr;

    }
    @Override
    public String toString(){
        String rez="";
        if (value.length>0){
            rez ="{";
            for (int i = 0; i < (value.length-1); i++) {
                rez = rez.concat(String.valueOf((int)value[i]))+",";
              }
              rez = rez + String.valueOf((int)value[value.length-1]);
            rez =rez+"}";
        }
        return rez;
    }




    @Override
    public Var sub(Var other) throws CallException, IOException {
        if (other instanceof Vector) {
            if ( (this.value.length)!= ((Vector) other).value.length){
                Util.putToFileUserAction(this+"-"+other,"",true);
                throw new CallException(Util.getError(Err.DifferenSizeVector));
            }
            double[] rez = new double[((Vector) other).value.length];
            for (int i = 0; i < ((Vector) other).value.length; i++) {
                rez[i] = this.value[i] - ((Vector) other).value[i];
            }
            Util.putToFileUserAction(this+"-"+other,String.valueOf(rez),false);
            return (new Vector(rez));
        }
        else if (other instanceof Scalar) {
            double[] rez = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                rez[i] = this.value[i] - ((Scalar) other).getValue();
            }
            Util.putToFileUserAction(this+"-"+other,String.valueOf(rez),false);
            return (new Vector(rez));
        }
        else return other.add(this);

    }

    @Override
    public Var mul(Var other) throws CallException, IOException {
        if (other instanceof Vector) {
            if ( (this.value.length)!= ((Vector) other).value.length){
                Util.putToFileUserAction(this+"*"+other,"",true);
                throw new CallException(Util.getError(Err.DifferenSizeVector));
            }
            double rez = ActionMatrix.mulToSum(this.value, ((Vector)other).value);
            Util.putToFileUserAction(this+"*"+other,String.valueOf(rez),false);
            return (new Scalar(rez));
        }
        else if(other instanceof Scalar){
            double[] rez = ActionMatrix.mul(((Scalar)other).getValue(),this.value);
            Util.putToFileUserAction(this+"*"+other,String.valueOf(rez),false);
            return (new Vector(rez));

        }
        else return other.add(this);
    }

    @Override
    public Var add(Var other) throws CallException, IOException {
        if (other instanceof Vector) {
            if ( (this.value.length)!= ((Vector) other).value.length){
                Util.putToFileUserAction(this+"+"+other,"",true);
                throw new CallException(Util.getError(Err.DifferenSizeVector));
            }
            double[] rez = new double[((Vector) other).value.length];
            for (int i = 0; i < ((Vector) other).value.length; i++) {
                rez[i] = this.value[i] + ((Vector) other).value[i];
            }
            Util.putToFileUserAction(this+"+"+other,String.valueOf(rez),false);
            return (new Vector(rez));
        }
        else if(other instanceof Scalar){
            double[] rez = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                rez[i] = this.value[i] + ((Scalar) other).getValue();
            }
            Util.putToFileUserAction(this+"+"+other,String.valueOf(rez),false);
            return (new Vector(rez));

        }
        else return other.add(this);
    }

    @Override
    public Var div(Var other) throws CallException, IOException {
        if (other instanceof Scalar){
            double[] rez = new double[this.value.length];
            if (((Scalar) other).getValue()!=0){
                for (int i = 0; i < this.value.length; i++) {
                    rez[i] = this.value[i] / ((Scalar) other).getValue();
                }
            }
            else{
                Util.putToFileUserAction(this+"/"+other,String.valueOf(rez),true);
                throw new CallException(Util.getError(Err.DifferenSizeVector));
            }
            Vector vector = new Vector(rez);
            Util.putToFileUserAction(this+"/"+other,String.valueOf(rez),false);

            return vector;
        }
        return null;
    }
}
