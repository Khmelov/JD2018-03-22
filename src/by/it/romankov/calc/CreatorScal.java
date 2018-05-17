package by.it.romankov.calc;

public class CreatorScal extends Creator{
    @Override
    public Scalar factoryMethod() {
        return new Scalar(8);
    }
}
