package by.it.kirova.calc;

public class Printer {

    static void print (Var var) {
        if (var != null)
            Logger.println(var.toString(), Logger.MessageType.CALC_OUTPUT);
        else
            Logger.println("переменная не найдена", Logger.MessageType.CALC_OUTPUT);
    }
}
