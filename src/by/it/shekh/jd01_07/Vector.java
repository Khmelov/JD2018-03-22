package by.it.shekh.jd01_07;

public class Vector extends AbstractVar {
    private double[] value;

    Vector (double... value) {
        this.value = value;
    }

    Vector(Vector otherVector){
        this.value=otherVector.value;
    }
    Vector(String line){
        String str=line.substring(1,line.length()-1);
        String[] strMas = str.trim().split(",");
        double[] value = new double[strMas.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strMas[i]);
        }
        this.value=value;
    }



    @Override
    public String toString() {
        String s="{";
        for (int i = 0; i <value.length ; i++) {
            s+=Double.toString(value[i]);
            if(i!=value.length-1) s+=", ";
        }
        s+="}";
        return s;
    }
}
