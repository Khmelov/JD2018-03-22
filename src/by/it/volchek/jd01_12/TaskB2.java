package by.it.volchek.jd01_12;

import by.it.volchek.jd01_11.ListB;

import java.util.*;


/**
 * Created by volchek on 17.04.18.
 */
public class TaskB2 {
    static String process(ArrayList<String> peoples){
        int initSize = peoples.size();
        int flagRemovaleFromTheStart =0;
        while(peoples.size()>1){
            Iterator<String> iterator = peoples.iterator();
            if ((peoples.size()<initSize) && (flagRemovaleFromTheStart>0))  {
                iterator.next();
                iterator.remove();
                flagRemovaleFromTheStart=0;

            }
            while (iterator.hasNext()){
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                else  flagRemovaleFromTheStart++;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int initSize = peoples.size();
        int flagRemovaleFromTheStart =0;
        while(peoples.size()>1){
            Iterator<String> iterator = peoples.iterator();
            if ((peoples.size()<initSize) && (flagRemovaleFromTheStart>0))  {
                iterator.next();
                iterator.remove();
                flagRemovaleFromTheStart=0;

            }
            while (iterator.hasNext()){
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                else  flagRemovaleFromTheStart++;
            }
        }
        return peoples.get(0);
    }





    public static void main(String[] args) {
    final List<String> NAMES = new ArrayList<>(Arrays.asList("Ivan", "Denis","Kirill","Anton","Gena","Dima","Petr","Pavel","Artem","Vlad"));
        System.out.println("Введите количество людей:");
        Scanner scanner=new Scanner(System.in);
    int peopleNumber = scanner.nextInt();
    LinkedList<String> lList = new LinkedList<>();
    ArrayList<String> arrList = new ArrayList<>();
        for (int i = 0; i < peopleNumber ; i++) {
            lList.add(NAMES.get((int)(Math.random()*9+1)));
            arrList.add(NAMES.get((int)(Math.random()*9+1)));
        }
        System.out.println("ArrayList:");
        System.out.println(arrList);
        System.out.println(process(arrList));

        System.out.println("LinkedList:");
        System.out.println(lList);
        System.out.println(process(lList));






    }
}
