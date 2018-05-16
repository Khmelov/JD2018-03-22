package by.it.poprugo.jd02_06.calc;

public interface Operation {
    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}
