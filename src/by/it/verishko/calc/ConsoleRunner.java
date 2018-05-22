package by.it.verishko.calc;

import java.io.*;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);
        String line;

        while (!(line = sc.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
        Logger logger = Logger.getLogger();
        logger.toLog("Message # " + 1);
    }
}
