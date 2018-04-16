package by.it.verishko.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ListA<>();
        myList.add("one");
        myList.add("one");
        System.out.println(myList);

        arList.add("one");
        arList.add("one");
        System.out.println(arList);


        myList.remove(0);
        System.out.println(myList);

        arList.remove(0);
        System.out.println(arList);
    }
}
