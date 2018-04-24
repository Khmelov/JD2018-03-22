package by.it.lyukovich.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
class Parser {
    Var calc(String expression) {
        //2.0*3.0
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String[] strOp = expression.split(Patterns.OPERATION);
            Var one = Var.createVar(strOp[0]);
            Var two = Var.createVar(strOp[1]);
            String operaton = m.group();
            switch (operaton) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return Var.createVar(expression);

    }
}
