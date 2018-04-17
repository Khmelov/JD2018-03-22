package by.it.kovko.calc;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("end")){
            if (line.equals("printvar"))
                Var.printVar();
            if (line.equals("sortvar"))
                Var.sortVar();
            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
