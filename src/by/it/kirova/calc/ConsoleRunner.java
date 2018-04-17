package by.it.kirova.calc;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Parser parser = new Parser();

        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            switch (line) {
                case "printvar":
                    Var.printvar();
                    break;
                case "sortvar":
                    Var.sortvar();
                    break;
                default:
                    Var result = parser.calc(line);
                    printer.print(result);
                    break;
            }

        }
    }
}
