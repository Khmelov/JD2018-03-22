package by.it.volchek.jd01_12;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;

/**
 * Created by volchek on 17.04.18.
 */
public class TaskB3 {

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
        final int peopleNumber = 4096;
        //System.out.println("Введите количество людей:");
        //Scanner scanner=new Scanner(System.in);
        //int peopleNumber = scanner.nextInt();
        LinkedList<String> lList = new LinkedList<>();
        ArrayList<String> arrList = new ArrayList<>();
        for (int i = 0; i < peopleNumber ; i++) {
            lList.add(NAMES.get((int)(Math.random()*9+1)));
            arrList.add(NAMES.get((int)(Math.random()*9+1)));
        }
        System.out.println("Тестирование ArrList");
        long iniTime = System.nanoTime();
        System.out.println(process(arrList));
        long delta = (System.nanoTime()-iniTime)/1000;
        System.out.println("Прошло времени: "+delta+" микросекунд");

        System.out.println("Тестирование LinkedList");
        iniTime = System.nanoTime();
        System.out.println(process(lList));
        delta = (System.nanoTime()-iniTime)/1000;
        System.out.println("Прошло времени: "+delta+" микросекунд");






    }
}
