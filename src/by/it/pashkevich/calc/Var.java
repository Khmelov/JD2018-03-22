package by.it.pashkevich.calc;


import by.it._examples_.jd01_11.Generics.Demo;

public abstract class Var implements Operation {

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        throw new CalcException("Ошибка обработки: "+strVar);
    }

    @Override
    public String toString() {
        return "Это класс AbstractVar";

    }

    @Override
    public Var add(Var other) throws CalcException {
       throw new CalcException("Операция сложения" + this + "+" + other +  "невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.printf("Операция вычитания %s-%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.printf("Операция умножения %s*%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s/%s невозможна\n", this, other);
        return null;
    }
}
