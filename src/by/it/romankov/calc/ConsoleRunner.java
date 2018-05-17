package by.it.romankov.calc;

import java.io.*;
import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {

VarSelektor varSelektor = new VarSelektor();
varSelektor.getVar("789");
        Printer printer = new Printer();
        Parser parser = new Parser();

        File file = new File(Util.getPathVarsTxt());
        if (file.exists())
            try (BufferedReader reader = new BufferedReader(
                    new FileReader(file))
            ) {
                String line;
                while ((line = reader.readLine()) != null)
                    parser.calc(line);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CalcException e) {
                System.out.println(e);
            }

        Logger logger = Logger.getLogger();
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
        logger.toLog(line);
            try {
                Var result = parser.calc(line);

                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}