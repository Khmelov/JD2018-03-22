package by.it.uskoryaev.calc;


import java.util.HashMap;
import java.util.Map;

abstract  class Var implements Operation{
    private  static  Map<String,Var> variabels = new HashMap<>();
    static Var createVar(String strVAr){
        strVAr = strVAr.replace("\\s+","").trim();
        if (strVAr.matches(Patterns.SCALAR))return new Scalar(strVAr);
        if (strVAr.matches(Patterns.VECTOR))return new Vector(strVAr);
        if (strVAr.matches(Patterns.VARNAME))
            return variabels.get(strVAr);

        /*if (strVAr.matches(Patterns.MATRIX))return new Matrix(strVAr);
        return new Matrix(strVAr);*/
     return null;
    }

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


    public static Var saveVar(String s, Var two) {
    }

    public static void saveVAr(String s, Var two) {

    }
}
