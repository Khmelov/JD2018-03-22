package by.it.desykevich.jd01_07;




class Scalar extends AbstractVar {

    private  double value;

    Scalar (double value){
        this.value=value;
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
