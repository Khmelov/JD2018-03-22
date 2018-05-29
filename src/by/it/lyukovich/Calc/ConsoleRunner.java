package by.it.lyukovich.Calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            if (line.equals("printvar")) {
                Var.printVars(); continue;}
            if (line.equals("sortvar")) {
                Var.sortVars(); continue;}
            try {
                String result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
