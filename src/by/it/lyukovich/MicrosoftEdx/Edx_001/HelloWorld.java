package by.it.lyukovich.MicrosoftEdx.Edx_001;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        String hw= "Hello World!";
        System.out.println(hw);
        System.out.println();
        String[] nw = new String[hw.length()]; //Создает стринговый массив
        //Выводит стринговый массив различными методами
        for (int i = 0; i < hw.length(); i++) {
            if (hw.substring(i, i+1).contains(" ")){
                System.out.println();
            }
            else System.out.println(hw.toCharArray()[i] + " - " + hw.substring(i,i+1) + " - " + hw.charAt(i));
        }
        System.out.println();

        System.out.println(hw.substring(0,hw.indexOf(" "))); //Берет 1-ю часть до пробела
        System.out.println(hw.substring(hw.indexOf(" ")+1,hw.length()));//Берет 2-ю часть после пробела
        System.out.println();
        System.out.println("Hello\nworld!");
        for (int i = 0; i < hw.length(); i++) {
            String nstring=new String();
            for (int j = 0; j < i; j++) {
                nstring+=" ";
            }
            nstring+=hw.charAt(i);
            System.out.println(nstring);

        }
        for (int i = hw.length()-1; i > -1 ; i--) {
            String nstring=new String();
            for (int j = 0; j < i; j++) {
                nstring+=" ";
            }
            nstring+=hw.charAt(i);
            System.out.println(nstring);

        }


    }

}
