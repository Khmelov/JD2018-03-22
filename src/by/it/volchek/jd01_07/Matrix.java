package by.it.volchek.jd01_07;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by volchek on 05.04.18.
 */
public class Matrix extends AbstractVar {
    private double[][]mtrx;
    Matrix(Matrix mtrx) {
        this.mtrx=mtrx.mtrx;
    }
   Matrix(double[][] mtrxMas) {
        this.mtrx=mtrxMas;
    }
    Matrix(String matrixString) {
        String s = matrixString.substring(1,matrixString.length()-1);
        String[] strMas = s.split("},");
        for (int i = 0; i <strMas.length ; i++) {
            if (i==strMas.length-1) strMas[i] = strMas[i].substring(1,strMas[i].length()-1);
            else
            strMas[i] = strMas[i].substring(1,strMas[i].length());

        }
        String[] rowNumber = strMas[0].split(",");
        mtrx = new double[strMas.length][rowNumber.length];
        for (int i = 0; i < strMas.length; i++) {
            String[] s1 = strMas[i].split(",");
            for (int j = 0; j <s1.length ; j++) {
                mtrx[i][j] = Double.parseDouble(s1[j]);
            }

        }


    }
    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i <mtrx.length ; i++) {
            sb.append("{");
            for (int j = 0; j < mtrx[0].length; j++) {
                if (j==mtrx[0].length-1) sb.append(mtrx[i][j]);
                else {
                    sb.append(mtrx[i][j]);
                    sb.append(",");

                }
            }
            sb.append("}");
            if(i<mtrx.length-1) sb.append(",");
        }
        sb.append("}");

        return sb.toString();
    }


}
