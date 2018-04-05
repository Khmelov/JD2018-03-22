package by.it.romankov.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        char[] o = {'ё', 'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю','И'};
        String s = Poem.text.replaceAll(",", "").replaceAll("\\.", "").replaceAll(":", "");

        String[] ss = s.split("\n");
        for ( int k = 0; k < ss.length; k++ ) {
            String[] str =ss[k].split(" ");
            for ( int i = 0; i < str.length; i++ ) {
                char[] c = str[i].trim().toCharArray();
                boolean firstSoglasnaya = true;
                boolean lastGlasnaya = false;
                for ( int j = 0; j < o.length; j++ ) {
                    if (o[j] == c[0]) {
                        firstSoglasnaya = false;
                    } else if (o[j] == c[c.length - 1]) {
                        lastGlasnaya = true;
                    }
                }
                if (firstSoglasnaya && lastGlasnaya) {
                    System.out.println(str[i]);
                }
            }
        }
    }
}

