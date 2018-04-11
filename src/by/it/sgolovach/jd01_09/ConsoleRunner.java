package by.it.sgolovach.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();

        Scanner scaner = new Scanner(System.in);

        String line;

        while (!(line = scaner.nextLine()).equals("end")) {
            Var reult = parser.calc(line);
            printer.print(reult);
        }
    }
}
