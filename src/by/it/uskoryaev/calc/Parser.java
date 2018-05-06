package by.it.uskoryaev.calc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expretion){
        //2.0*3/0
        String [] strOP = expretion.split(Patterns.OPERATION);
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expretion);
        if (m.find()){
            String [] strOp = expretion.split(Patterns.OPERATION);
            String operation = m.group();
            Var two = Var.createVar(strOP[1]);
            Var.saveVAr(strOP[0],two);
            if (operation.equals("=")&&strOp[0].matches(Patterns.VARNAME))
                return Var.saveVar(strOp[0],two);
            Var one = Var.createVar(strOP[0]);
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return Var.createVar(expretion);
    }
}
