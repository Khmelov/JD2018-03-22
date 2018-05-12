package by.it.sgolovach.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    List<String> priority = new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));

    List<String> operation;
    List<String> operand;

    private int getNumOperation() {
        int curnum = -1;
        int prior = -1;

        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            int p = priority.indexOf(op);
            if (p > prior) {
                curnum = i;
                prior = p;
            }
        }
        return curnum;
    }

    Var calc(String expression) throws CalcException {

        operand=new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));

        operation=new ArrayList<>();

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
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

        while (operation.size()>0){
            int index=getNumOperation();
            String op = operation.remove(index);

           Object oLeft= operand.get(index);
           Object oRight=operand.remove(index+1);
        }
        return Var.createVar(operand.get(0));
    }

}
