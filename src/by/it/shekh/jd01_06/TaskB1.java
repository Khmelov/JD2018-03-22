package by.it.shekh.jd01_06;

public class TaskB1 {
    static char[] letters = {'ы', 'и', 'а', 'о', 'е', 'э', 'ё', 'я', 'ю', 'у'};//массив гласных букв

    static boolean wordChck(String word) {
        int startLetter = 0, lastLetter = 0;
        char fiLetter = word.toLowerCase().charAt(0);
        char laLetter = word.toLowerCase().charAt(word.length() - 1);
        for (char ch : letters) {
            if (fiLetter == ch) startLetter++;//проверка на гласную первой буквы. Если таковая, то увеличиваем
            if (laLetter == ch) lastLetter++;
        }
        if (lastLetter > startLetter) return true;//вернет true, если первая буква будет согласной, а последняя гласной
        else return false;
    }

    public static void main(String[] args) {
        String pattern = "[,-;.?!:\\s]+";
        String mas[] = Poem.text.split(pattern);
        for (String s : mas) {
            if (wordChck(s))
                System.out.println(s);

        }
    }
}
