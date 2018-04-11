package by.it.poprugo.jd01_07;

class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] strings = new String[0];
        strings = strMatrix.split("},");
        int rowNum = strings[0].split(",").length; // костыль: матрица прямоугольная
        double[][] arrParsed = new double[strings.length][rowNum];
        for (int i = 0; i < strings.length; i++) {
            String[] rows = new String[0];
            rows = strings[i].split(",");
            for (int j = 0; j < rows.length; j++) {
                rows[j] = rows[j].replaceAll("[^(\\d+.?\\d+)]", " ").trim();
                arrParsed[i][j] = Double.parseDouble(rows[j]);
            }
        }
        this.value = arrParsed;
    }

    @Override
    public String toString() {
        StringBuilder sbM = new StringBuilder("{{");
        String signBoundRow = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sbM.append(signBoundRow).append(value[i][j]);
                if (j < value[i].length - 1) signBoundRow = ", ";
                else signBoundRow = "}, {";
            }
        }
        sbM.append("}}");
        return sbM.toString();
    }
}