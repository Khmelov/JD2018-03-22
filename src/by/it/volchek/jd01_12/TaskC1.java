package by.it.volchek.jd01_12;

import java.util.*;


/**
 * Created by volchek on 18.04.18.
 */
public class TaskC1 {
    static int i =5;

    static int uniqueInt (){
        return i=i+5;
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split("[\\s]+");
        Map<Integer,String> myMap = new TreeMap<>();
        for (String word : words) {
            if(!(myMap.containsValue(word)))
            myMap.put(uniqueInt(),word);
        }

        for (;;){
            str = scanner.nextLine();
            if (str.equals("end")) break;
            words = str.split("[\\s]+");
            for (String word : words) {
                if (myMap.containsValue(word)) myMap.put(uniqueInt(),word);
            }
        }

        Map<Integer,String> tmpMap = new TreeMap<>();
        int key;
        String value;

        for (Iterator<Integer> iter = myMap.keySet().iterator();iter.hasNext();){
            key = iter.next();
            value = myMap.get(key);
            if (!(tmpMap.containsValue(value)))
                tmpMap.put(key,value);
        }
        for (Map.Entry<Integer, String> integerStringEntry : tmpMap.entrySet()) {
            System.out.println(integerStringEntry.getKey()+" "+integerStringEntry.getValue());
        }


    }
}
