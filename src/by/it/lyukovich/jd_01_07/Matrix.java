package by.it.lyukovich.jd_01_07;

public class Matrix extends AbstractVar {
    private double value[][];
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
            if (value==null)
                value = new double[match.length][values.length];
                for (int j = 0; j < values.length; j++) {
                    if(values[j]!=null){
                    value[i][j] = Double.parseDouble(values[j]);}
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            if (i<value.length-1){sb.append("{");}
            for (int j = 0; j < value[i].length; j++) {
                if (j==0 && i>0){sb.append(",{");}
                sb.append(value[i][j]);
                if(j<value[i].length-1){sb.append(", ");}
                if (j==value[i].length-1){sb.append("}");}
            }
            if (i==value.length-1){sb.append("}");}
        }

        String string=new String(sb);
        return string;
    }


}
