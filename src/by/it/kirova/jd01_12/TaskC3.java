package by.it.kirova.jd01_12;

import java.util.*;

public class TaskC3 {

    private static Set<Character> open = new HashSet<>(Arrays.asList('{', '(', '['));
    private static Set<Character> close = new HashSet<>(Arrays.asList('}', ')', ']'));


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Boolean res = getRes(line);
        System.out.println(res);
    }


    private static boolean getRes(String line) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            int type = getCharType(ch);
            switch (type) {
                case -1:
                    deque.addLast(ch);
                    break;
                case 1:
                    if (deque.isEmpty())
                        return false;
                    char x = deque.pollLast();
                    if (!validate(x, ch))
                        return false;
                    break;
                default:
                    break;
            }

        }
        return deque.isEmpty();
    }


    private static int getCharType(char ch) {
        if (open.contains(ch)) {
            return -1;
        }
        if (close.contains(ch)) {
            return 1;
        }
        return 0;
    }

    private static boolean validate(char left, char right) {
        switch (left) {
            case '{':
                return right == '}';
            case '(':
                return right == ')';
            case '[':
                return right == ']';
            default:
                return false;
        }
    }

}
