package by.it.sgolovach.jd01_12;

import java.util.*;


public class TaskB1 {

    private static int repeat(List<String> list, String o) {
        int res = 0;
        for (String s : list) {
            if (s.equals(o)) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String str = "";
        String patSign = "[-— ,.\\!\\?;:\\\"\\/1-9()]+";

        List<String> list = new ArrayList<>();
        while (!(str = scaner.next()).equals("end")) {
            list.addAll(Arrays.asList(str.split(patSign)));
        }

        Set<String> stre = new HashSet<>(list);

        for (String s : stre) {
            System.out.println(s + "=" + repeat(list, s));

        }


    }
}