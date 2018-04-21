package by.it.danilevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        SortSentence();
    }
    private static void SortSentence(){
        String poema = Poem.text;

        String[] predlozenie = poema.split("[.?!][\\n]");
        //уберем из предложения небуквенные символы
        for (int j = 0; j <predlozenie.length ; j++) {
            Pattern pattern  = Pattern.compile("[-,\n]");
            Matcher matcher = pattern.matcher(predlozenie[j]);
            while (matcher.find()){
                predlozenie[j] = matcher.replaceAll( " ");
            }
            predlozenie[j] = predlozenie[j].trim();
        }

        int[][] razmernostPredl = new int[predlozenie.length][2];
        for (int i=0; i<predlozenie.length;i++) {
            String stroka = predlozenie[i].trim();
            razmernostPredl[i][0]=i;
            razmernostPredl[i][1]=stroka.length();
        }
        //отсортируем по размерности
        int[][] newMas = sort(razmernostPredl);
        for (int[]elem: newMas) {
            int TekInd = elem[0];
            System.out.println(predlozenie[TekInd]);
        }
    }

    private static int[][] sort(int[ ][ ] arr){
        //по возрастанию
        int dlina = arr.length;
        while (dlina > 0) {
            for (int i = 0; i < (dlina-1); i++) {
                //int perv = arr[i][1];
                //int vtor = arr[i+1][1];
                if (arr[i][1] > arr[i+1][1]) {
                    int vrem1 = arr[i][0];
                    int vrem2 = arr[i][1];
                    arr[i][0] = arr[i+1][0];
                    arr[i][1] = arr[i+1][1];
                    arr[i+1][0] = vrem1;
                    arr[i+1][1] = vrem2;
                }
            }
            dlina = dlina - 1;
        }
        return arr;
    }
}