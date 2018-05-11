package by.it.poprugo.jd01_09;

abstract class Var implements Operation {

    static Var createVar(String strVar) {
        strVar=strVar.replaceAll("\\s+","").trim();
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        return null; // надо сгенерировать сообщение об ошибке
    }

    private double value;

    @Override
    public String toString() {
        //return Double.toString(value);
        return "Это класс AbstractVar";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s+%s is impossible\n",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s-%s is impossible\n",this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s*%s is impossible\n",this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s/%s is impossible\n",this,other);
        return null;
    }
}
