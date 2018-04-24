package by.it.lyukovich.Calc;


@SuppressWarnings("Duplicates")
public class Matrix extends Var {
    //В разработке

    /*private double value[][];
    Matrix(double[][] value){
        this.value= value;
    }
    Matrix(Matrix matrix){
        this.value=matrix.value;
    }
    Matrix(String strMatrix){
        strMatrix = strMatrix.substring(2, strMatrix.length() - 2);
        String[] match= strMatrix.split("},\\{");
        for (int i = 0; i < match.length; i++) {
            String[] values = match[i].split(",( *)");
            if (value==null) {
                value = new double[match.length][values.length];
            }
                for (int j = 0; j < values.length; j++) {
                    value[i][j] = Double.parseDouble(values[j]);
            }
        }
    }

    @Override
    public Var add(Var other){
        if(other instanceof Scalar){
            Scalar scalar = (Scalar)other;
            double v=scalar.getValue();
            double[][] res= Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]+=v;
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Vector){
            Vector vector = (Vector)other;
            double[][] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]+=vector.value[i];
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix){
            Matrix mnew = (Matrix)other;
            double[][] res=Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]+=mnew.value[i][j];
                }
            }
            return new Matrix(res);
        }
        else
            return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if(j<value[i].length-1){sb.append(", ");}
                if (j==value[j].length-1 && i< value[i].length-1){sb.append("},{");}
                else if(j==value[j].length-1 && i== value[i].length-1){sb.append("}}");}
            }
        }
        return new String(sb);
    }*/

}
