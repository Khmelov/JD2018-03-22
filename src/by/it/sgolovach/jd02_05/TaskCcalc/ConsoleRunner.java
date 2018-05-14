package by.it.sgolovach.jd02_05.TaskCcalc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


class ConsoleRunner {

    static ResourceManager rm = ResourceManager.INSTANCE;

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


        Scanner scanner = new Scanner(System.in);
        String line;
        int lang = 0;
        System.out.println(rm.get(Messages.LANGUAGE1) + "\nru - "
                + rm.get(Messages.LANGUAGE2) + "\nbe - "
                + rm.get(Messages.LANGUAGE3) + "\nen - "
                + rm.get(Messages.LANGUAGE4));
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("ru")) {
                rm.setLocale(new Locale("ru", "RU"));
                lang++;
            }
            if (line.equals("be")) {
                rm.setLocale(new Locale("be", "BY"));
                lang++;
            }
            if (line.equals("en")) {
                rm.setLocale(Locale.US);
                lang++;
            }
            if (lang == 0) {
                try {
                    Var result = parser.calcExpression(line);
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
            lang = 0;
        }

    }
}
