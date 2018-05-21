package by.it.danilevich.calc;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static ResourceManager rm = ResourceManager.INSTANCE;
    public static void main(String[] args) throws IOException {
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
            } catch (CallException e) {
                System.out.println(e);
            }

        System.out.println("Выберите язык вывода: ru/be/en");
        Scanner scanner = new Scanner(System.in);
        String rez = scanner.nextLine();
        String lang = "ru";
        String country = "RU";
        if(rez.equals("en")){
            lang = "en";
            country = "US";
        }
        else if (rez.equals("be")){
            lang = "be";
            country = "BY";
        }

        Locale curlocale = new Locale(lang,country);
        rm.setLocale("err",curlocale);
        Util.rm = rm;

        String line;

         Util.setFullReport(Math.random() > 0.5);
         if (Util.getFullReport()) System.out.println("Будет формироваться полный отчет");
         else System.out.println("Будет формироваться краткий отчет");

         Util.createLogBuilder();
         PrintFile.getInstance().setLogBuilder(Util.getLogBuilder());
         //PrintFile.getInstance().toLog(PrintFile.getInstance().getLogger().getTitle());
//         Util.putToFileUserAction("adding 9-3","6",false);



        Util.putTitleToFile("Начало работы");

        while (!(line = scanner.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CallException e) {
                System.out.println(e.getMessage());
            }
        }
        Util.putTitleToFile("Окончание работы");

    }
}
