package by.it.kirova.calc;

public class VarFactory {

    static abstract class Creator {
        public abstract Var parse(String s);
    }

    static class CreatorScalar extends Creator {
        @Override
        public Var parse(String s) { return new Scalar(s); }
    }

    static class CreatorVector extends Creator {
        @Override
        public Var parse(String s) { return new Vector(s); }
    }

    static class CreatorMatrix extends Creator {
        @Override
        public Var parse(String s) { return new Matrix(s); }
    }
}
