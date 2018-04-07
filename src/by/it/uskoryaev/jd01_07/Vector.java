package by.it.uskoryaev.jd01_07;


class Vector extends AbstractVar {
    private double [] value;
    public String toString(){
        StringBuilder rex = new StringBuilder();
        for (double i:value) {
            rex.append(Double.toString(i)).append(", ");
        }

        return "{" + rex.toString().replaceAll(", $","") + "}";
    }

    Vector(double[] value){
        this.value = value;
    }
    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector(String strVector){
        String[] str = strVector.substring(1,strVector.length()-1).split(",");
        value = new double[str.length];
        for (int i = 0; i <str.length; i++) {
            value[i]= Double.parseDouble(str[i]);

        }




    }
}
