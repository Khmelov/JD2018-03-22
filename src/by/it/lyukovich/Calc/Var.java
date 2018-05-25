package by.it.lyukovich.Calc;

public abstract class Var implements Operation {

    static Var createVar(String operand){
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        /*if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);*/
        /*if (strVar.matches(Patterns.VARNAME))
            return new Vector(operand);*/
        return null;
    }
    @Override
    public String toString() {
        return "Это класс AbstractVar";
    }
    void aaa(){}

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " +this + "-" + other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычетания " +this + "-" + other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " +this + "-" + other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " +this + "-" + other+" невозможна");
        return null;
    }
}
