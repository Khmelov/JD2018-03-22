package by.it.kovko.calc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Locale us = new Locale("en", "US");
        Locale ru = new Locale("ru", "RU");
        Locale by = new Locale("be", "BY");
//        Errors.changeLocale(us);
//        System.out.println(Errors.NO_OPERATION);
//        Errors.changeLocale(ru);
//        System.out.println(Errors.NO_OPERATION);
//        Errors.changeLocale(by);
//        System.out.println(Errors.NO_OPERATION);

        //System.out.println(res.getString("NO_OPERATION"));
        //System.out.println(Errors.NO_OPERATION);



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
//            if (line.equals("printvar"))
//                Var.printVar();
//            if (line.equals("sortvar"))
//                Var.sortVar();
            switch (line){
                case "printvar": Var.printVar();
                case "sortvar": Var.sortVar();
                case "ru": Errors.setLocale(ru);break;
                case "by": Errors.setLocale(by);break;
                case "us": Errors.setLocale(us);break;
            }
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
