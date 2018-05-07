package by.it.fando.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList=new ListA<>();
        List<String> arList=new ArrayList<>();
        myList.add("one");
        myList.add("two");
        System.out.println(myList);

        arList.add("one");
        arList.add("two");
        System.out.println(arList);

        myList.remove(0);
        System.out.println(myList);

        arList.remove(0);
        System.out.println(arList);

    }
}
