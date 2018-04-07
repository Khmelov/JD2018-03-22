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
        return other.add(this);
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
