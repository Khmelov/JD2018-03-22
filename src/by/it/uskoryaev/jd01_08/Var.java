package by.it.uskoryaev.jd01_08;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "это класс AbstractVar{}";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция сложения %s-%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция сложения %s*%s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция сложения %s/%s невозможна\n", this, other);
        return null;
    }
}
