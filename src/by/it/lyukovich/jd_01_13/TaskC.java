package by.it.lyukovich.jd_01_13;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc;
    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        readData();
    }
    static void readData() throws Exception {
        String str; int counter=0;
        ArrayDeque<Double> numbers = new ArrayDeque<>();
        while(!(str = sc.next()).equalsIgnoreCase("END")) {
            try{
                numbers.addFirst(Double.parseDouble(str));
            } catch (Exception e){
                if (++counter==5)
                    throw e;
                Thread.sleep(100);
                System.out.println(numbers.toString().replaceAll("[^0-9. ]",""));
            }
        }
    }
}
