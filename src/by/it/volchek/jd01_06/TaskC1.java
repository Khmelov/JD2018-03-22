package by.it.volchek.jd01_06;

/**
 * Created by volchek on 03.04.18.
 */
public class TaskC1 {

    static String[] textToArray(String s) {
        String pattern = "\\n";
        String[] strMas = s.split(pattern);
        return strMas;
    }

    static int findMaxLength(String[] strMas) {
        int maxLength = 0;
        for (int i = 0; i < strMas.length; i++) {
            if (maxLength < strMas[i].length()) maxLength = strMas[i].length();
        }
        return maxLength;
    }

    static String widthFormat(String s, int maxLength) {
        int div = maxLength - s.length();
        String wSpace = " ";
        String[] strMas = s.split(wSpace);
        int wordNumber = strMas.length;
        int wSpaceNumber = (int) ((div + wordNumber - 1) / (wordNumber - 1));
        int modWSpaceNumber = (div + wordNumber - 1) % (wordNumber - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strMas.length - 1; i++) {
            sb.append(strMas[i]);
            for (int j = 0; j < wSpaceNumber; j++) {
                sb.append(" ");
            }
            if (modWSpaceNumber > 0) {
                sb.append(" ");
                modWSpaceNumber--;
            }
        }
        sb.append(strMas[strMas.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = textToArray(Poem.text);
        int maxLength = findMaxLength(arr);

        for (String s :
                arr) {
            System.out.println(widthFormat(s, maxLength));

        }

    }


}
