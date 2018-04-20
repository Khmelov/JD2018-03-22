package by.it.danilevich.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends AbstractVar{
    public double[] value;
    Vector(double[ ] value){
        this.value = value;
    }
    Vector(Vector vector){
        this.value = vector.value;
    }
    Vector(String strVector){
        Pattern pattern  = Pattern.compile("([{}])");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()){
            strVector = matcher.replaceAll( " ");
        }

        String[] num = strVector.split(",");
        double[] arr = new double[num.length];
        for (int i = 0; i < num.length; i++) {
            String symbol = String.valueOf(num[i]);
            arr[i] = Double.parseDouble(symbol);
        }
        this.value = arr;

    }
    @Override
    public String toString(){
        String rez="";
        if (value.length>0){
            rez ="{";
            for (int i = 0; i < (value.length-1); i++) {
                rez = rez.concat(String.valueOf(value[i]))+", ";
              }
              rez = rez + String.valueOf(value[value.length-1]);
            rez =rez+"}";
        }
        return rez;
    }

}
