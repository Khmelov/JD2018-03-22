package by.it.danilevich.jd01_12;
import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        System.out.println("Введите id паспорта и фамилию сотрудника");
        Scanner scanner=new Scanner(System.in);
        String line;
        List<String[]> a = new ArrayList<String[]>();
        Map<Integer,String> data = new HashMap<Integer, String>();
        while (!(line=scanner.nextLine()).equals("end")){
              String[] arr = line.split(" ");
              if (arr.length==2){
                  a.add(arr);
                  data.put(Integer.valueOf(arr[0]),arr[1]);
              }
         }
        System.out.println("Полученные данные: ");
        for (String[] el: a) {
            System.out.print(el[0]+"=" + el[1] + " ");
        }
        System.out.println();
        System.out.println("Отсортированные данные не сделаны: ");

        for (String[] el: a) {
            data.put(Integer.valueOf(el[0]),el[1]);
        }
          System.out.println("Уникальные данные" + data);
    }
}
