package by.it.poprugo.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer=new Printer();
        Parser parser=new Parser();
        Scanner scanner=new Scanner(System.in);
        String line;
        while (!(line=scanner.nextLine()).equals("end")) {
            try {
                Var result=parser.calc(line);
                printer.print(result);
            }
            catch (CalcExeption e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
