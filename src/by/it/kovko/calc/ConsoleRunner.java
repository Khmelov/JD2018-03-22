package by.it.kovko.calc;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {

        Printer printer = new Printer();
        Parser parser = new Parser();
        try(BufferedReader bufread = new BufferedReader(new FileReader(Util.getPathVarsTxt()))) {
            String line;
            while ((line=bufread.readLine())!= null){
                System.out.println(line);
                parser.calc(line);
            }
        } catch (IOException e) {}
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("end")){
            if (line.equals("printvar"))
                Var.printVar();
            if (line.equals("sortvar"))
                Var.sortVar();
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
