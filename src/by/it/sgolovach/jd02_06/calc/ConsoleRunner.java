package by.it.sgolovach.jd02_06.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


class ConsoleRunner {

    static ResourceManager rm = ResourceManager.INSTANCE;

    static Logger logger;

    static Director director;

    public static void main(String[] args) {

        director = new Director();
        ReportBuilder reportBuilder = Math.random() > 0.5 ? new SmallReportBuilder() : new BigReportBuilder();
//        ReportBuilder reportBuilder = new BigReportBuilder();
        director.setReportBuilder(reportBuilder);
        director.buildReport();


        logger.toLog("Начало программы!!!");
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


        Scanner scanner = new Scanner(System.in);
        String line;
        int lang = 0;
        logger.toLog("Выбор языка приложения ");
        System.out.println(rm.get(Messages.LANGUAGE1) + "\nru - "
                + rm.get(Messages.LANGUAGE2) + "\nbe - "
                + rm.get(Messages.LANGUAGE3) + "\nen - "
                + rm.get(Messages.LANGUAGE4));
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("ru")) {
                rm.setLocale(new Locale("ru", "RU"));
                logger.toLog("Выбор языка приложения " + rm.get(Messages.LANGUAGE2));
                lang++;
            }
            if (line.equals("be")) {
                rm.setLocale(new Locale("be", "BY"));
                logger.toLog("Выбор языка приложения " + rm.get(Messages.LANGUAGE3));
                lang++;
            }
            if (line.equals("en")) {
                rm.setLocale(Locale.US);
                logger.toLog("Выбор языка приложения " + rm.get(Messages.LANGUAGE4));
                lang++;
            }
            if (lang == 0) {
                try {
                    logger.toLog("Введено выражение - " + line);
                    Var result = parser.calcExpression(line);
                    printer.print(result);
                    logger.toLog("Выведен результат выражения = " + result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
            lang = 0;
        }

        logger.toLog("Завершение программы!!!");
        director.finishReport();

    }
}
