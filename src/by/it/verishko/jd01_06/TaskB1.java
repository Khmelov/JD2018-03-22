package by.it.verishko.jd01_06;

public class TaskB1 {

    private static char[] vowels = {'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю', 'ё', 'У', 'Е', 'Ы', 'А', 'О', 'Э', 'Я', 'И', 'Ю', 'Ё'};

    public static void main(String[] args) {
        String[] words = Poem.text.split("[\\s,;:.!?-]+");
        for (String word : words) {
            if (word.length() > 1) {
                char[] ch = word.toCharArray();
                if (!letter(vowels, ch[0]) &&
                        letter(vowels, ch[ch.length - 1])) {
                    System.out.printf("%s ", word);
                }
            }
        }
    }

    private static boolean letter(char[] array, char ch) {
        for (char element : array) {
            if (element == ch)
                return true;
        }
        return false;
    }
}