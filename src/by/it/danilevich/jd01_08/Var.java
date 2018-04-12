package by.it.danilevich.jd01_08;

abstract class Var implements Operation {
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
