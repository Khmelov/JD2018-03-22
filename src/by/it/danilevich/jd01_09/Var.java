package by.it.danilevich.jd01_09;

abstract class Var implements Operation {

    static Var createVar(String strVar){
        if (strVar.matches(Patterns.SCALAR) ) return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR) ) return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX) ) return new Matrix(strVar);
       // if (strVar.matches(Patterns.SCALAR) ) return new Scalar(strVar);
        else return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " c " + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " +   this + " c " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "  + this + " c " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " c " + other + " невозможна");
        return null;
    }
    @Override
    public String toString(){
        return "Это класс Абстракт";
    }

}
