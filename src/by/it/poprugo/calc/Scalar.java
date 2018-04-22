package by.it.poprugo.calc;

class Scalar extends Var {

    private double value;

    public double getValue() { //???
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) { //можно передать Scalar
        //или его потомков !не предков !никого, кроме Scalar
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar); //this - это поле класса
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double res=this.value+((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
        //return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double res=this.value-((Scalar) other).value;
            return new Scalar(res);
        }
        return new Scalar(-1).mul(other).add(this);
        //return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double res=this.value*((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
        //return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            if (((Scalar) other).value==0)
            throw new CalcExeption("Dividing by zero");
            double res=this.value/((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(other); //т.к. скаляр НЕ делится ни на вектор, ни на матрицу
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}