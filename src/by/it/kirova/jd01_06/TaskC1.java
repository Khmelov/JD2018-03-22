package by.it.kirova.jd01_06;

import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\n");
        String[] lines = p.split(Poem.text);
        int[] counter = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
            counter[i] = lines[i].length();
        }
        int max = getMax(counter);
        String[] justifyLines = justify(lines, max);
        printArray(justifyLines);

    }

    private static int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > max)
                max = element;
        }
        return max;
    }

    private static String[] justify(String[] array, int max) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            int diff = max - array[i].length();
            String[] words = array[i].split(" ");
            int spaceQuantity = diff / (words.length - 1) + 1;
            int extraLimit = diff % (words.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length - 1; j++) {
                sb.append(words[j]);
                for (int k = 0; k < spaceQuantity; k++) {
                    sb.append(' ');
                }
                if (extraLimit > j) {
                    sb.append(' ');
                }

            }
            sb.append(words[words.length - 1]);
            result[i] = sb.toString();
        }
        return result;
    }

    private static void printArray(String[] arr) {
        for (String element : arr) {
            //System.out.print(element.length() + " ");
            System.out.println(element);
        }
    }
}






