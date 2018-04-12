package by.it.poprugo.jd01_08;

abstract class Var implements Operation {

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
