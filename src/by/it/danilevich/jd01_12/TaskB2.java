package by.it.danilevich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;


public class TaskB2{
    public static void main(String[] args) {
        //String[] arrPeople = {"Иванов","Петров","Белов","Курников","Ивашко","Петрашко","Леонтьев","Леонидов"};//,"Валенов","Шапкин","Дашкин"};
        int count =4;
        String[] arrPeople = new String[count];
        for (int i = 1; i <=count ; i++) {
            arrPeople[i-1] = "n" + i;
        }
        List<String> peoples1 = new ArrayList<>(Arrays.asList(arrPeople));
        LinkedList<String> peoples2 = new LinkedList<>(Arrays.asList(arrPeople));

    //    peoples1 = new ArrayList<E>(Arrays.asList(arrPeople));
        String man1 = process((ArrayList<String>) peoples1);
        System.out.println(man1);
        System.out.println(process(peoples2));


    }


    private static String process(ArrayList<String> peoples){
        String rez;
        System.out.println(peoples);
        int counter =0;
            Iterator<String> iterator = peoples.iterator();
            int countPeople = peoples.size();
            while (countPeople>1){
                if (peoples.size()==1) break;
                iterator.next();
                if (counter==0){
                    counter=1;
                }
                else {
                    iterator.remove();
                    counter=0;
                    countPeople--;
                }
                if (!iterator.hasNext() &&countPeople>1) iterator = peoples.iterator();
            }
        rez = peoples.get(0);
        return rez;

    }

    private static String process(LinkedList<String> peoples){
     /*   String rez;
        ArrayList<String> tempArrList = new ArrayList<>();
        System.out.println(peoples);
        while (peoples.size()!=1){
            for (int i =0; i<peoples.size();i++) {
                if ((i+1)%2!=0) tempArrList.add(peoples.get(i));

            }
            peoples.clear();
            peoples.addAll(tempArrList);
            tempArrList.clear();
            System.out.println(peoples);
        }
        rez = peoples.get(0);
        return rez;*/
        String rez;
        System.out.println(peoples);
        int counter =0;
        Iterator<String> iterator = peoples.iterator();
        int countPeople = peoples.size();
        while (countPeople>1){
            if (peoples.size()==1) break;
            iterator.next();
            if (counter==0){
                counter=1;
            }
            else {
                iterator.remove();
                counter=0;
                countPeople--;
            }
            if (!iterator.hasNext() &&countPeople>1) iterator = peoples.iterator();
        }
        rez = peoples.get(0);
        return rez;

    }
}



