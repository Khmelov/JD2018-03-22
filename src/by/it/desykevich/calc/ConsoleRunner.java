package by.it.desykevich.calc;

import java.util.Scanner;

public class ConsoleRunner  {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
        String line;
        while (!(line=scanner.nextLine()).equals("end")){
            Var result=parser.calc(line);
            printer.print(result);
        }
    }
}
