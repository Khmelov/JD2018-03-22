package by.it.kovko.calc;

class Printer {
    Logger logger = Logger.getLogger();
    void print(Var var){
        if (var!=null) {
            logger.toLog(var.toString());
            System.out.println(var);
        }
    }
}
