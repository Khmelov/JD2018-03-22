package by.it.volchek.Calc;

import java.util.Scanner;

/**
 * Created by volchek on 10.04.18.
 */
public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner=new Scanner(System.in);
        String line;
       while (!(line = scanner.nextLine()).equals("end")){
           if (line.equals("printvar")) {Var.printVariables(); continue;}
           if (line.equals("sortvar")) {Var.sortVariables(); continue;}
           try {


               Var result = parser.calc(line);
               printer.print(result);
           }
           catch (CalcException e){
               System.out.println(e.getMessage());
           }

       }
    }
}
