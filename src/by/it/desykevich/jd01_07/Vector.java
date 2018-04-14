package by.it.desykevich.jd01_07;

public class Vector extends  AbstractVar {

    private double[] value;

     Vector(double[] value){

        this.value=new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector vector){

        this(vector.value);
    }

    Vector(String strVector){

        String[]str= strVector.substring(1,strVector.length()-1).split(",");
        this.value=new double[str.length];
        for (int i = 0; i <this.value.length; i++) {
            this.value[i]=Double.parseDouble(str[i]);
            
        }
    }
    @Override

    public String toString(){
        StringBuilder result= new StringBuilder();
        result.append('{');
        for (int i = 0; i <value.length ; i++) {

            if (i>0) result.append(", ");
            result.append(value[i]);
            
        }
        result.append('}');
        return result.toString();

    }

}
