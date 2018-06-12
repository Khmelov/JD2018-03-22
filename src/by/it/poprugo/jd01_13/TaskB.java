package by.it.poprugo.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskB {
    /*
    TaskB. В классе TaskBнапишите цикл, который:
считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
переводит каждую строку в вещественное число и выводит в консоль данное число
и корень из суммы всех ранее введенных чисел, включая введенное;
если перевести ввод в число невозможно, то программа перехватывает полученную ошибку
и показывает сообщение в консоли сообщение, такого же формата, как в предыдущем задании
если невозможно извлечь корень, то обработка аналогична, но тип ошибки -ArithmeticException
     */
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        double sum = 0, sqt, num;
        try {
            while (!(str = reader.readLine()).equals("END")) {
                num = Double.parseDouble(str);
                sum += num;
                if (sum < 0)
                    throw new ArithmeticException();
                sqt = Math.sqrt(sum);
                System.out.println(num + " " + sqt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTraceElement = e.getStackTrace();
            for (StackTraceElement element : stackTraceElement) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    System.out.println("name: " + e.getClass().getName() +
                            "\nclass: " + element.getClassName() +
                            "\nline: " + element.getLineNumber());
                    break;
                }
            }
        }
    }
}
