package by.it.pashkevich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String[] strOP = expression.split(Patterns.OPERATION);
            Var one = Var.createVar(strOP[0]);
            Var two = Var.createVar(strOP[1]);
            String operation = m.group();
            switch (operation) {
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
