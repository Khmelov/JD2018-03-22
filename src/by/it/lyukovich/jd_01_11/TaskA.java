package by.it.lyukovich.jd_01_11;

import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        List<String> myList=new ListA<>();
        List<String> arList=new ArrayList<>();
        myList.add("First"); arList.add("First");
        myList.add("Two"); arList.add("Two");
        myList.add("Four"); arList.add("Four");
        System.out.println("myList: "+myList+"\narList: "+arList);
    }
}
