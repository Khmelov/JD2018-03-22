package by.it.lyukovich.Calc;

import java.lang.invoke.CallSite;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

    List<String> operations;
    List<String> operands;

    private static final HashMap<String, Integer> priorityList = new HashMap<String, Integer>() {
        {
            this.put("=", 0); this.put("+", 1); this.put("-", 1); this.put("*", 2); this.put("/", 2);
        }
    };

    String calc(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.DELIM);
        Matcher m = pattern.matcher(expression);
        String line;
        while (m.find()) {
            line = m.group();
            expression = expression.replace("(" + line + ")", calc(line));
            m.reset(expression);
        }
        operations = new ArrayList<>();
        operands = new ArrayList<>();

        Collections.addAll(operands, expression.split(Patterns.OPERATION));
        if (operands.size() < 2) {
                return Objects.requireNonNull(Var.createVar(expression)).toString();
        } else {
            Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = operationPattern.matcher(expression);
            while (matcher.find()) {operations.add(matcher.group());}
            while (operations.size() > 0) {
                int curOp = getCurrentOperation();
                String first = operands.get(curOp);
                String op = operations.remove(curOp);
                String second = operands.remove(curOp + 1);
                String res = operateCalc(first, op, second);
                operands.set(curOp, res);
            }
            return operands.get(0);
        }
    }

    private int getCurrentOperation() {
        int baseOp = -1;
        int current = -1;
        for (int i = 0; i < operations.size(); i++) {
            int curOp = priorityList.get(operations.get(i));
            if (curOp > baseOp) {
                baseOp = curOp;
                current = i;
            }
        }
        return current;
    }

    private String operateCalc(String first, String op, String second) throws CalcException {
        Var two = Var.createVar(second);
        if (op.equals("=")) {
            Var.saveVar(first, two);
            return two.toString();
        }
        Var one = Var.createVar(first);
        if (one == null || two == null)
            throw new CalcException(String.format("Error: %s%s%s:", first, op, second));
        switch (op) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
            default:
                throw new CalcException("Недопустимая операция");
        }
    }
}
