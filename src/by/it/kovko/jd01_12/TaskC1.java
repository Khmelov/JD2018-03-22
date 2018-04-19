package by.it.kovko.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line;
//        while(!(line = scanner.next()).equals("end")){
//
//        }
        Map<Integer,String> myMap = new TreeMap<>();
        List<String> mlist = new ArrayList<>(Arrays.asList(
                "One","Two","Three","Three","Two","Two"));
        int pin=0;
        for (String s : mlist) myMap.put(pin+=(Math.random()*100+1),s);
        Map<Integer, String> compressedMap = new TreeMap<>(myMap);
        System.out.println("Original map "+myMap.toString());
        System.out.println("Before compression "+compressedMap.toString());
        Collection<String> values = compressedMap.values();
        Iterator<String> it = values.iterator();
        while (it.hasNext())
            if (Collections.frequency(values,it.next())>1)
                it.remove();
        System.out.println("After compression "+compressedMap.toString());
    }
}
