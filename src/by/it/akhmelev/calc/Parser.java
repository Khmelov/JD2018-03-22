package by.it.akhmelev.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    List<String> priority =
            new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));

    List<String> operations;
    List<String> operands;

    private int getNumOperation() {
        // = + + * / - -
        int curnum = -1;
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
        //D=2.0*3.0/5+3

        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size() > 0) {
            int index = getNumOperation();
            String op = operations.remove(index);
            String oLeft = operands.get(index);
            String oRight = operands.remove(index + 1);
            operands.set(index, calcOneOperation(oLeft, op, oRight).toString());
        }
        return Var.createVar(operands.get(0));
    }

    private Var calcOneOperation(String strVarLeft, String operaton, String strVarRight) throws CalcException {
        Var two = Var.createVar(strVarRight); // a=9
        if (operaton.equals("=") && strVarLeft.matches(Patterns.VARNAME))
            return Var.saveVar(strVarLeft, two);
        Var one = Var.createVar(strVarLeft);
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
        throw new CalcException("Нет такой операции");
    }
}
