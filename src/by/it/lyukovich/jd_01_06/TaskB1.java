package by.it.lyukovich.jd_01_06;
public class TaskB1 {
    private final static char[] lastlet ={'а','е','ё','и','о','у','э','ы','ю','я'};

    public static void main(String[] args) {
        String pattern = "[-,;:.!?\\s]+";
        String[] strMas = Poem.text.split(pattern);

        for (String s: strMas) {
            if (checkWord(s)) System.out.println(s);
        }
    }
    private static boolean checkWord (String s){
        int cStart=0;
        int cEnd=0;
        char charStart = s.toLowerCase().charAt(0);
        char charEnd;
        charEnd = s.toLowerCase().charAt((s.length()-1));
        for (char charcheck:lastlet) {
            if (charStart==charcheck) {
                cStart++;
            }
            if (charEnd==charcheck) {
                cEnd++;
            }
        }
        return cStart < cEnd;
    }
}
