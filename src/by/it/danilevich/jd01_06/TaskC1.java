package by.it.danilevich.jd01_06;

import java.util.Arrays;

public class TaskC1 {
    public static void main(String[] args) {
        String[] poema = Poem.text.split("\\n");
        int[] razmery = new int[poema.length];
        for (int i = 0; i < poema.length; i++) {
            razmery[i] = poema[i].length();
        }
        Arrays.sort(razmery);
        int maxRazmer = razmery[razmery.length-1];

        for (int i = 0; i < poema.length; i++) {
            //
            int razmerStroki = poema[i].length();
            String[] slova = poema[i].split(" ");
            int kolSlov = slova.length - 1;//последнее слово не берем
            int needSpace = maxRazmer - razmerStroki;
            if (needSpace==0) continue;
            if (needSpace>kolSlov){
                //сколько доп пробелов на одно слово
                int spaceWord = needSpace/kolSlov;
                int ostatok = needSpace - spaceWord*kolSlov;
                poema[i] ="";
                String razd ="";
                for (int j = 0; j < spaceWord; j++) {
                    razd = razd + " ";/////может быть несколько
                }
                String dopRazd="";
                if (ostatok>0) dopRazd = " ";

                for (int j = 0; j < (slova.length-1); j++) {
                    poema[i] = poema[i] + slova[j] + " " + razd+dopRazd;
                    ostatok = ostatok -1;
                    if (ostatok<=0) dopRazd="";

                }
                poema[i] = poema[i] + slova[slova.length-1];

            }
            else {
                poema[i] ="";
                String razd = " ";
                for (int j = 0; j < (slova.length-1); j++) {
                    poema[i] = poema[i] + slova[j] + " " + razd;
                    needSpace = needSpace -1;
                    if (needSpace<=0) razd="";
                }
                poema[i] = poema[i] + slova[slova.length-1];
            }

        }

        for (int i = 0; i < poema.length; i++) {
           System.out.println(poema[i]);
        }

    }

}
