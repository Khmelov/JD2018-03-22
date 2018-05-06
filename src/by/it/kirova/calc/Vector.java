package by.it.kirova.calc;


import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;

    }

    Vector(String strVector) {
        String[] s = strVector.substring(1, strVector.length() - 1).split(",");
        value = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += v;
            }
            return new Vector(sum);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора имеют разную длину. Операция сложения невозможна");
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Vector) other).value[i];
            }
            return new Vector(sum);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other)throws CalcException{
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= v;
            }
            return new Vector(sub);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора имеют разную длину. Операция вычитания невозможна");
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] mul = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= v;
            }
            return new Vector(mul);
        } else if (other instanceof Vector) {
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора имеют разную длину. Операция умножения невозможна");
            double[] mul = Arrays.copyOf(this.value, this.value.length);
            double sum = 0;
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= ((Vector) other).value[i];
                sum += mul[i];
            }
            return new Scalar(sum);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other)throws CalcException {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] div = Arrays.copyOf(this.value, this.value.length);
            if (v == 0)
                throw new CalcException("Деление на ноль");
            for (int i = 0; i < div.length; i++) {
                div[i] /= v;
            }
            return new Vector(div);
        } else
            return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length - 1; i++) {
            sb.append(value[i]).append(", ");
        }
        sb.append(value[value.length - 1]);
        return "{" + sb.toString() + "}";

    }
}
