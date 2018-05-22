package by.it.volchek.jd02_06;

public class ArrayIndexOutOfBoundsException implements Exeption {

    @Override
    public void doExeption() {
        int[] arr = new int[2];
        arr[2] = 5;
    }
}
