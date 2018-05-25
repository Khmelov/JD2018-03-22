package by.it.lyukovich.jd_01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String text= Poem.text;
        int length= getLineLenght(text)-1;
        String result = reformatString(text, length);
        System.out.print(result);
    }

    static int  getLineLenght(String s){
        String[] string = s.split("\n");
        int lineLength=0;
        for (String line : string){
            if (lineLength < line.length()) lineLength = line.length();
        }
        return lineLength;
    }

    static String reformatString(String s, int length){
        String[] original = s.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line: original){
            if (line.length() < length) {
                sb.append(reformatLine(line, length)).append("\n");
            } else sb.append(line).append("\n");
        }
        return sb.toString();
    }

    static String reformatLine (String line, int maxLength){
        String[] words = line.split(" ");
        StringBuilder sb = new StringBuilder();
        int lineLength = line.length()-words.length;
        int difference = maxLength-lineLength;
        while (difference != 0) {
            for (int i = 0; i < words.length-1; i++) {
                if (difference != 0) {
                    words[i] = words[i] + ' ';
                    difference--;
                }
            }
        }
        for (String word: words){
            sb.append(word);
        }
        return sb.toString();
    }
}
