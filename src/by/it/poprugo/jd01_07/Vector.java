package by.it.poprugo.jd01_07;

class Vector extends AbstractVar {

    private double[] value;

    /*public Vector(String[] v) {
        this.v = v;
    }*/


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
            v[i]=v[i].replaceAll("[^(\\d+.?\\d+)]"," ").trim();
            valParsed[i]=Double.parseDouble(v[i]);
        }
        this.value = valParsed;
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