package by.it.lyukovich.jd_01_07;

import java.util.Arrays;

public class Vector extends AbstractVar{
    private double value[];
    Vector(double[] value){
        this.value= Arrays.copyOf(value,value.length);
    }
    Vector(Vector vector){
        this.value=vector.value;
    }
    Vector(String strVector){
        String strValues[]=strVector.replaceAll("[{}]","").split(",");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }
    @Override
    public String toString() {
        return "{"+Arrays.toString(value).replaceAll("[\\[\\]]","")+"}";
    }

}
