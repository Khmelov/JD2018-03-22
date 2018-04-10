package by.it.matyuta.jd01_08;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "Это класс Abstract";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция вычитания %s-%s невозможна\n");
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}
