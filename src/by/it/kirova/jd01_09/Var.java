package by.it.kirova.jd01_09;

public abstract class Var implements Operation {

    static Var createVar(String strVar) {
        strVar = strVar.replaceAll("\\s+", "").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        return null;
    }

    @Override
    public String toString() {
        return "Это класс AbstractVar{}";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s-%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s*%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s/%s невозможна\n", this, other);
        return null;
    }
}
