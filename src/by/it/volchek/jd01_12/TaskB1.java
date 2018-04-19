package by.it.volchek.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by volchek on 17.04.18.
 */
public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str;
    /*    for(;;){
            str = scanner.nextLine();
            if (str.equals("end")) break;\\s\\s
            sb.append(str);
        }
        String text = sb.toString();*/
        str = Test_jd01_12.text.trim();
        String[] arr = str.split("[\\s.,:;!?—]+");

        Map<String,Integer> words = new HashMap<>();
        for (String s : arr) {
            if (words.get(s)==null) words.put(s,1);
            else words.put(s,words.get(s)+1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : words.entrySet()) {
            System.out.println(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());

        }

    }
}
