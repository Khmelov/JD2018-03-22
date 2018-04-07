package by.it.danilevich.jd01_07;

import java.security.SecureRandom;

public class Matrix extends AbstractVar{
    private double[][] value;
    Matrix(double[ ][ ]  value){
        this.value = value;
      }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        String[] tempArr = strMatrix.split("},");
        int countColumn = 0;
        //
        if (tempArr.length !=0) {
            String tempS = tempArr[0].replaceAll("\\{", "");
            tempS = tempS.replaceAll("\\}", "");
            String[] temp = tempS.split(",");
            countColumn = temp.length;
            tempS = "{" + tempS + "}";
        }

        double[][] arr = new double[tempArr.length][countColumn];
        for (int i = 0; i < tempArr.length; i++) {
            String tempS = tempArr[i].replaceAll("\\{", "");
            tempS = tempS.replaceAll("\\}", "");
            tempS = "{" + tempS + "}";
             Vector v = new Vector(tempS);
             arr[i] = v.value;
        }
        this.value = arr;


    }
    @Override
    public String toString(){
        String rez ="", symbBegin = "{", symbEnd="}";
        int lastString = value.length;
        int lastColumn = value[lastString-1].length;
        rez = rez + symbBegin;
        for (int i = 0; i < lastString; i++) {
            rez = rez + symbBegin;
            for (int j = 0; j < (value[i].length -1); j++) {
                rez = rez + Double.toString(value[i][j]) +", ";
            }
            if (i==(lastString-1) ) rez = rez + Double.toString(value[i][value[i].length-1])+ symbEnd;
            else rez = rez + Double.toString(value[i][value[i].length-1])+ symbEnd+", ";
        }
        rez = rez + symbEnd;

        return rez;
    }
}
