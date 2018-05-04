package by.it.poprugo.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] v = new String[0];
        v = strVector.split("[,]+");
        double[] valParsed = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = v[i].replaceAll("[^(\\d+.?\\d+)]", " ").trim();
            valParsed[i] = Double.parseDouble(v[i]);
        }
        this.value = valParsed;
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            //Vector res=new Vector(this);
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            Vector vector = ((Vector) other);
            // Vector res= new Vector(this); //res - это потомок Var, возвращаем Var, а значит имеем право вернуть res
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
            //return res; res - это потомок Var...
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            //Vector res=new Vector(this);
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            return new Scalar(-1).mul(other).add(this);
        } else return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * v;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                Vector vector = ((Vector) other);
                // Vector res= new Vector(this);
                double res = 0;
                for (int i = 0; i < this.value.length; i++) {
                    res += this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(res);
            } else {
                System.out.println("Multiplying of different length vectors is impossible");
                return super.mul(other);
            }
        } else return super.mul(other);
   }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / v;
            }
            return new Vector(res);
        } else return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String signBound = "";
        for (double each : value) {
            sb.append(signBound).append(each);
            signBound = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}