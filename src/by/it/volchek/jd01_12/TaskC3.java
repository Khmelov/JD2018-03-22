package by.it.volchek.jd01_12;

import java.util.*;

/**
 * Created by volchek on 18.04.18.
 */
public class TaskC3 {

    private static final List<Character> START_QUOTES = new ArrayList<>(Arrays.asList('{','[','('));


    private static boolean isQuotesOpposite(char a, char b) {
        return (a == '{') && (b == '}') || (a == '[') && (b == ']') || (a == '(') && (b == ')');
    }

    private static boolean checkQuotes(char[] letters){
        ArrayDeque<Character> quotes = new ArrayDeque<>();
        for (char c : letters) {
            if(START_QUOTES.contains(c)) quotes.add(c);
            else if (quotes.isEmpty()) return false;
            else if (!(isQuotesOpposite(quotes.pollLast(),c))) return false;
        }
        return quotes.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.nextLine();
        String line = str.replaceAll("[^\\{\\}\\[\\]\\(\\)]+","");
        char[]letters = line.toCharArray();
        System.out.println(checkQuotes(letters));
    }
}
