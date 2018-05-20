package by.it.poprugo.jd02_06.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String exp) {
        Pattern p = Pattern.compile(Patterns.OPERATION);
        String[] operands = exp.split(p.toString());
        //System.out.println("exp after split() into operands[] " + exp);
        Var var1 = Var.createVar(operands[0]);
        Var var2 = Var.createVar(operands[1]);
        if (var1 == null || var2 == null) return null;
        Matcher matcher = p.matcher(exp);
        if (matcher.find()) {
            switch (matcher.group()) {
                case "+" : return var1.add(var2);
                case "-" : return var1.sub(var2);
                case "*" : return var1.mul(var2);
                case "/" : return var1.div(var2);
            }
        }
        return null;
    }
}
