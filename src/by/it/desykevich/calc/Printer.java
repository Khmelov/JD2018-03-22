package by.it.desykevich.calc;

import java.util.AbstractMap;
import java.util.TreeMap;

public class Printer {

private Logger logger;
    void print(String var) {
        if (var != null)
            System.out.println(var);
        logger = Logger.getLogger();
        logger.logWrite(var);
    }

    void printVariable() {
        System.out.println(Variable.map);
        logger = Logger.getLogger();
        logger.logWrite(Variable.map.toString());
    }

    void sortVariable() {
        AbstractMap<String, Var> sortedMap = new TreeMap<>(Variable.map);
        System.out.println(sortedMap);
        logger = Logger.getLogger();
        logger.logWrite(sortedMap.toString());
    }
}
