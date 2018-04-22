package by.it.kovko.jd01_13;

import java.util.*;


public class TaskC {
    private static Scanner scanner;
    static void readData() throws InterruptedException {
        String str; int counter=0;
        ArrayDeque<Double> nums = new ArrayDeque<>();
        while(!(str = scanner.next()).equals("END")) {
            try{
                nums.addFirst(Double.parseDouble(str));

            } catch ( NumberFormatException e){
                if (++counter==5)
                    throw e;
                Thread.sleep(100);
                System.out.println(nums.toString().replaceAll("[^0-9. ]",""));
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }
}

