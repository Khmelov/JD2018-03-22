package by.it.kovko.jd01_07;


class Scalar extends AbstractVar{
    private double value;
    Scalar(){}
    Scalar(double value){
        this.value=value;
    }
    Scalar(Scalar scalar){
        this.value=scalar.value;
    }
    Scalar(String strScalar){
        value=Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
