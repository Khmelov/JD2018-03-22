package by.it.volchek.jd01_07;

import java.util.Arrays;

/**
 * Created by volchek on 05.04.18.
 */
 class Vector extends AbstractVar {
    private double[] var;

   Vector(double[] var) {
        this.var = var;
    }
    Vector(String str) {
        String s = str.substring(1,str.length()-1);
        String[] strMas = s.split(",");
        this.var = new double[strMas.length];
        for (int i = 0; i <strMas.length ; i++) {
            var[i] = Double.parseDouble(strMas[i]);
        }
    }
   Vector(Vector vector) {
        this.var = vector.var;
    }
    @Override

   /*  public String toString() {
        if (this.var == null)
            return "null";
        int iMax = this.var.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(this.var[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }*/
    public String toString(){
        String s = Arrays.toString(this.var);
        s= s.replace('[','{');
        s=s.replace(']','}');
        return s;

    }

}




