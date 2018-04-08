package by.it.desykevich.jd01_08;


class Scalar extends Var {

    private  double value;

    Scalar (double value){

        this.value=value;
    }

    @Override
    public  Var add (Var other){
        if (other instanceof Scalar){
            double res=this.value+((Scalar)other).value;
            return  new Scalar(res);
        }
        else return  other.add(this);
    }

    @Override
    public  Var sub (Var other){
        if (other instanceof Scalar){
            double sub=this.value-((Scalar)other).value;
            return  new Scalar(sub);
        }
        else return  new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul (Var other) {
        if (other instanceof Scalar){
            double mul=this.value * ((Scalar)other).value;
            return  new Scalar(mul);
        }
        else return  other.mul(this);
    }

    @Override
    public  Var div (Var other){
        if (other instanceof Scalar){
            double div=this.value / ((Scalar)other).value;
            return  new Scalar(div);
        }
        return  super.div(other);
    }



    Scalar (String str){
        value=Double.parseDouble(str);
    }

    Scalar (Scalar otherScalar){
        this.value=otherScalar.value;
    }

    @Override
    public String toString() {
        return  Double.toString(value);
    }
}
