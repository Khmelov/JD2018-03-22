package by.it.danilevich.calc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws IOException {
        Printer printer=new Printer();
        Parser parser=new Parser();
        Scanner scanner=new Scanner(System.in);
        String line;

        try {
            BufferedReader reder = new BufferedReader(new FileReader(Util.getPathVarsTxt()));
          //  String line;
          //  while (line = reder.readLine())!=null){

           // }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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
