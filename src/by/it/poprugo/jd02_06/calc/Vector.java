package by.it.poprugo.jd02_06.calc;

import java.util.Arrays;

class Vector extends Var {
    private double[] arrOneDim;

    double[] getValue() { return arrOneDim; }

    Vector(double[] value) { this.arrOneDim = value; }

    Vector(Vector vector) { this.arrOneDim = vector.arrOneDim; }

    Vector(String strVector) {
        //String[] s = strVector.substring(1, strVector.length() - 1).split(",");
        String[] sArray = strVector.replaceAll("[{,}]", " ")
                .trim().split("\\s+");
        arrOneDim = new double[sArray.length];
        for (int i = 0; i < arrOneDim.length; i++) {
            arrOneDim[i] = Double.parseDouble(sArray[i]);
        }
    }

    @Override
    public Var add(Var other) {
        double[] resAd = Arrays.copyOf(this.arrOneDim, this.arrOneDim.length);
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            for (int i = 0; i < resAd.length; i++) {
                resAd[i] += vector.arrOneDim[i];
            }
            return new Vector(resAd);
        } else if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            for (int i = 0; i < resAd.length; i++) {
                resAd[i] += scalar.getValue();
            }
            return new Vector(resAd);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] resSu = Arrays.copyOf(arrOneDim, arrOneDim.length);
            for (int i = 0; i < resSu.length; i++) {
                resSu[i] -= vector.getValue()[i];
            }
            return new Vector(resSu);
        } else if (other instanceof Scalar) {
            return new Scalar(-1).mul(other).add(this);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            if (this.arrOneDim.length == vector.getValue().length) {
                double resMu = 0;
                for (int i = 0; i < this.arrOneDim.length; i++) {
                    resMu += this.arrOneDim[i] * vector.getValue()[i];
                }
                return new Scalar(resMu);
            }
            System.out.println("Different length vectors multiplying is impossible");
            return super.mul(other);
        } else if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] resMu = Arrays.copyOf(arrOneDim, arrOneDim.length);
            for (int i = 0; i < resMu.length; i++) {
                resMu[i] *= scalar.getValue();
            }
            return new Vector(resMu);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] resDi = Arrays.copyOf(arrOneDim, arrOneDim.length);
            for (int i = 0; i < resDi.length; i++) {
                resDi[i] /= scalar.getValue();
            }
            return new Vector(resDi);
        } else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(arrOneDim)
                .replace('[', '{')
                .replace(']', '}');
    }
    /*public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String signBound = "";
        for (double each : value) {
            sb.append(signBound).append(each);
            signBound = ", ";
        }
        sb.append("}");
        return sb.toString();
    }*/
}