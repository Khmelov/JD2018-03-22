package by.it.kirova.calc;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Parser parser = new Parser();

        String path = Util.getPathVarsTxt();
        File f = new File(path);


        String logPath = Util.getLogPath();
        Logger.setLoggerPath(logPath);
        if(f.exists() && !f.isDirectory()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(Util.getPathVarsTxt()))) {
                String line;
                while ((line = reader.readLine()) != null)
                    parser.calc(line);
            } catch (IOException e) {
                Logger.printErrorStackTrace(e);
            } catch (CalcException e) {
                Logger.printErrorMessage(e);
            }
        }


        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            Logger.println(line, Logger.MessageType.USER_INPUT);
            switch (line) {
                case "printvar":
                    Var.printvar();
                    break;
                case "sortvar":
                    Var.sortvar();
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        Printer.print(result);
                    }
                    catch (CalcException e) {
                        Logger.printErrorMessage(e);
                    }

            }

        }

    }
}
