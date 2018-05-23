package by.it.uskoryaev.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    private Logger logger = new Logger();

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(String strValue) {
        String[] sArray = strValue
                .replace('{', ' ').replace('}', ' ')
                .trim().split(",\\s*");
        value = new double[sArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(sArray[i]);
        }
    }

    Vector(Vector varScalar) {
        this(varScalar.value);
    }


    @Override
    public Var add(Var otherVar) throws CalcException {
        if (otherVar instanceof Vector) {
            Vector result = new Vector(this);
            checkSize((Vector) otherVar);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] += ((Vector) otherVar).value[i];
            return result;
        } else if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] += ((Scalar) otherVar).getValue();
            return result;
        } else
            return super.add(otherVar);

    }

    private void checkSize(Var otherVar) throws CalcException {
        if (this.value.length != ((Vector) otherVar).value.length)
            throw new CalcException("Различный размер векторов");
    }

    @Override
    public Var sub(Var otherVar) throws CalcException {
        if (otherVar instanceof Vector) {
            checkSize(otherVar);
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] -= ((Vector) otherVar).value[i];
            return result;
        } else if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] -= ((Scalar) otherVar).getValue();
            return result;
        } else
            return super.sub(otherVar);
    }

    @Override
    public Var mul(Var otherVar) throws CalcException {
        if (otherVar instanceof Vector) {
            double sum = 0;
            checkSize(otherVar);
            for (int i = 0; i < this.value.length; i++)
                sum += this.value[i] * ((Vector) otherVar).value[i];
            return new Scalar(sum);

        } else if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] *= ((Scalar) otherVar).getValue();
            return result;

        } else
            return super.add(otherVar);

    }

    @Override
    public Var div(Var otherVar) throws CalcException {
        if (otherVar instanceof Scalar) {
            Vector result = new Vector(this);
            for (int i = 0; i < result.value.length; i++)
                result.value[i] /= ((Scalar) otherVar).getValue();
            return result;
        } else
            return super.div(otherVar);
    }

    @Override
    public String toString() {
        return Arrays.toString(value)
                .replace('[', '{')
                .replace(']', '}');
    }
}
