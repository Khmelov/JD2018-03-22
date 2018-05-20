package by.it.kirova.calc;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static ResourceManager rm = ResourceManager.INSTANCE;
    public static void main(String[] args) {

        BaseReport.getReport().addDate(new Date());
        Printer printer = new Printer();
        Parser parser = new Parser();

        String path = Util.getPathVarsTxt();
        File f = new File(path);

        if(f.exists() && !f.isDirectory()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(Util.getPathVarsTxt()))) {
                String line;
                while ((line = reader.readLine()) != null)
                    parser.calc(line);
            } catch (IOException e) {
                Logger.getLogger().printErrorStackTrace(e);
            } catch (CalcException e) {
                Logger.getLogger().printErrorMessage(e);
            }
        }


        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            Logger.getLogger().println(line, Logger.MessageType.USER_INPUT);
            switch (line) {
                case "printvar":
                    Var.printvar();
                    break;
                case "sortvar":
                    Var.sortvar();
                    break;
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "US"));
                    break;
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        Printer.print(result);
                    }
                    catch (CalcException e) {
                        Logger.getLogger().printErrorMessage(e);
                    }

            }
        }
        BaseReport.getReport().addDate(new Date());
        BaseReport.getReport().print();
    }
}
