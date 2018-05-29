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
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                if (j == value[0].length - 1) sb.append(value[i][j]);
                else {
                    sb.append(value[i][j]);
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i < value.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }


}
