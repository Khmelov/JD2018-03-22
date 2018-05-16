package by.it.romankov.calc;

class Printer {
    Logger logger = Logger.getLogger();
    void print(Var var){
        if (var!=null){
            System.out.println(var);
            logger.toLog(var.toString());
    }
    }

}
