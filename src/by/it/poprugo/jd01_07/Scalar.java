package by.it.poprugo.jd01_07;

class Scalar extends AbstractVar {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) { //можно передать Scalar
        //или его потомков !не предков !никого, кроме Scalar
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar); //это - поле класса
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}