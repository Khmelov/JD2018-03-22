package by.it.poprugo.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] strings = Poem.text.split("\n");
        int maxSentLen = 0;
        for (String string : strings) {
            if (string.length() > maxSentLen) maxSentLen = string.length();
        }
        int[] wordsNum = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String[] word = strings[i].split(" ");
            wordsNum[i] = word.length;
            int delta = maxSentLen - strings[i].length();
            int count = (int) (delta / (wordsNum[i] - 1));
            int mod = delta % (wordsNum[i] - 1);
            for (int j = 0; j < word.length - 1; j++) {
                for (int k = 0; k < count + 1; k++) {
                    word[j] = word[j].concat(" ");
                }
            }
            if (mod > 0) {
                for (int j = 0; j < mod; j++) {
                    word[j] = word[j].concat(" ");
                }
            }
            strings[i] = "";
            for (int j = 0; j < wordsNum[i]; j++) {
                strings[i] = strings[i].concat(word[j]);
            }
            System.out.println(strings[i]);
        }
    }
}