package by.it.danilevich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer=new Printer();
        Parser parser=new Parser();
       // {{1,2},{8,3}}-{{2,3,3},{2,3,3}}
       // {{1,2},{8,3}}*{{1,2},{8,3}}
       // {{-1.0, -1.0}, {6.0, 0.0}}
       // {{17.0, 8.0}, {32.0, 25.0}}
        Scanner scanner=new Scanner(System.in);
        String line;

        while (!(line=scanner.nextLine()).equals("end")){
            try{
                Var result=parser.calc(line);
                printer.print(result);
            }
            catch (CallException e){
                System.out.println(e.getMessage());
            }

        }

    }
}
