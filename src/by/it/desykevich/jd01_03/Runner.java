package by.it.desykevich.jd01_03;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"v",3);
        System.out.println("Минимум массива min:"+Helper.findMin(array));
        System.out.println("Максимум массива max:"+Helper.findMax(array));
        Helper.sort(array);
        System.out.println("Массив отсоритирован по возростанию:");
        InOut.printArray(array,"v",3);
    }
}
