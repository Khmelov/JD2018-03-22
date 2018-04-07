package by.it.sgolovach.jd01_06;


import java.util.Arrays;

public class TaskC2 {

    static String[] text2 = new String[0];

    static String text1 = new String();


    public static void main(String[] args) {

        long start = System.nanoTime();
        String str3 = slow(Poem.text);
        System.out.println(str3);
        long slow1 = System.nanoTime() - start;
        System.out.println(slow1);
        String str4 = fast(Poem.text);
        System.out.println(str4);
        long fast1 = System.nanoTime() - start - slow1;
        System.out.println(fast1);
        System.out.println(slow1 / fast1);


    }

    static String slow(String text) {

        String str1 = new String(text);
        String[] elemString1 = str1.split("[!.,\\s:-]+");

        for (int i = 0; i < 145; i++) {
            for (int j = 0; j < elemString1.length; j++) {
                int a = (int) (Math.random() * (elemString1.length - 1));
                int last = text2.length;
                text2 = Arrays.copyOf(text2, last + 1);
                text2[last] = elemString1[a];

            }
        }

        for (int i = 0; i < text2.length; i++) {
            text1 = text1 + text2[i] + " ";
        }


        String[] elemString = text1.split(" ");

        String str = new String();
        String ch = " ";
        for (int i = 0; i < elemString.length; i++) {
            if (str.length() <= 100000) {
                str = str.concat(elemString[i]);
                str = str.concat(ch);
            }
        }
        return str;
    }

    static String fast(String text) {
        String[] elemString = text1.split(" ");

        StringBuilder sb = new StringBuilder();
        String ch = " ";
        for (int i = 0; i < elemString.length; i++) {
            if (sb.length() <= 100000) {
                sb.append(elemString[i]);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
