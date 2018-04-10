package by.it.shekh.jd01_07;

public class Matrix extends AbstractVar {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    Matrix(String line) {
        String str = line.substring(1, line.length() - 1);

        String[] masMas = str.split("},");
        for (int i = 0; i < masMas.length; i++) {
            if (i == masMas.length - 1)
                masMas[i] = masMas[i].substring(1, masMas[i].length() - 1);//Удаляем первую в каждом подмассиве и последнюю скобки
            else masMas[i] = masMas[i].substring(1, masMas[i].length());
        }

        String elemCol[] = masMas[0].split(",");
        value = new double[masMas.length][elemCol.length];
        for (int i = 0; i < masMas.length; i++) {
            String[] strr = masMas[i].split(",");
            for (int j = 0; j < strr.length; j++) {
                value[i][j] = Double.parseDouble(strr[j]);
            }
        }


    }


    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i < value.length; i++) {
            s += "{";
            for (int j = 0; j < value[0].length; j++) {
                s += Double.toString(value[i][j]);
                if (j != value[0].length - 1) s += ", ";
            }
            s += "}";
            if (i != value.length - 1) s += ", ";
        }
        s += "}";
        return s;
    }
}
