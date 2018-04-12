package by.it.shvedov.jd01_07;

class Vector extends AbstractVar{
    private double[] value;

    Vector(double[] value) {
        this.value =new double [value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector vector){
        this.value=vector.value;
    }
    Vector(String strVector ){
        String[] mas = strVector
                .replace('{',' ').replace('}',' ')
                .trim().split(",\\s");
        value=new double[mas.length];
        for (int i = 0; i <value.length ; i++) {
            value[i]=Double.parseDouble(mas[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimetr="";
        for (double element : value) {
            sb.append(delimetr).append(element);
            delimetr=", ";

        }
        sb.append("}");
        return sb.toString();

    }
}
