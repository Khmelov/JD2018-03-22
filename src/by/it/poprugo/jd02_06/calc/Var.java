package by.it.poprugo.jd02_06.calc;

abstract class Var implements Operation {

    static Var createVar(String operand) {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        return null;
    }

    @Override
    public String toString() {
        return "This is AbstractVar";
    }

    @Override
    public Var add(Var other) {
        System.out.println("operation " + this + "+" + other + " is impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("operation " + this + "-" + other + " is impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("operation " + this + "*" + other + " is impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("operation " + this + "/" + other + " is impossible");
        return null;
    }
}
