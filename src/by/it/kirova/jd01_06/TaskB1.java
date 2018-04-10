package by.it.kirova.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String[] words = Poem.text.split("[\\s,;:.!?-]+");
        char[] vowels = new char[]{'А', 'Я', 'У', 'Ю', 'И', 'Ы', 'Э', 'Е', 'О', 'Ё', 'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
        for (String word : words) {
            if (word.length() > 1) {
                char[] wordToChar = word.toCharArray();
                if (!charArrayContainsChar(vowels, wordToChar[0]) &&
                        charArrayContainsChar(vowels, wordToChar[wordToChar.length - 1])) {
                    System.out.println(word);
                }
            }
        }

    }


    private static boolean charArrayContainsChar(char[] array, char ch) {
        for (char element : array) {
            if (element == ch)
                return true;
        }
        return false;
    }


}