package by.it.shvedov.jd01_06;

import java.util.Arrays;

public class TaskB2 {
    public static void main(String[] args) {
       // char[] array = {};
        StringBuilder sb = new StringBuilder(Poem.text);
        String mas[] = Poem.text.split("[.?!]");
        boolean swap;
        //Arrays.sort(mas);
        int last = mas.length - 1;
        do {
            swap = false;
            for (int i = 0; i < mas.length; i++) {
                if (mas[i].length() > mas[i + 1].length()) {
                    String buffer = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        System.out.println(Arrays.toString(mas));
    }
}


