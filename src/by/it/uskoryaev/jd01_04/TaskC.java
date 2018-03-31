package by.it.uskoryaev.jd01_04;


public class TaskC {
    public static void main(String[] args) {

    }
    static void buildOneDimArray(String line){
        double [] array = InOut.getArray(line);
        System.out.println("unsorted array");
        InOut.printArray(array);
        double first = array[0];
        double last = array[array.length-1];
        System.out.println("sorted array");
        InOut.printArray(array,"V",4);
        System.out.println("find new index");
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == first){
                System.out.println("first element="+i);
                break;
            }
        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == last){
                System.out.println("last element="+i);
                break;
            }
        }
    }
}
