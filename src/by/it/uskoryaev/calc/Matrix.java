package by.it.uskoryaev.calc;

public class Matrix extends Var {

    @Override
    public Var add(Var other) {
        // Слаживаем матрицу и скаляр
        // Слаживаем матрицу и матрицу
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        // матрица - скаляр
        // матрица - матрица
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        //матрицу * скаляр
        //матрицу * вектор
        //матрицу * матрицу
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        //матрицу на скаляр
        return super.div(other);
    }
}
