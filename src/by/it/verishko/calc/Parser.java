package by.it.verishko.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    List<String> priority = new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));

    List<String> operations;
    List<String> operands;

    private int getNumberOperation() {
        int curnum = 0;
        int prior = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int p = priority.indexOf(op);
            if (p > prior) {
                curnum = i;
                prior = p;
            }
        }
        return curnum;
    }


    Var calc(String expression) throws CalcException {
        //2.0*3.0
        operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        operations = new ArrayList<>();

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);


        while (m.find()) {
            String[] strOp = expression.split(Patterns.OPERATION);
            String operation = m.group();
            String strVarLeft = strOp[0];
            String strVarRight = strOp[1];


            Var two = Var.createVar(strVarRight);
            if (operation.equals("=") && strVarLeft.matches(Patterns.VARNAME))
                return Var.saveVar(strVarLeft, two);
            Var one = Var.createVar(strVarLeft);
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