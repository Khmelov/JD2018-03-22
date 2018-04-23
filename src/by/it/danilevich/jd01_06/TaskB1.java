package by.it.danilevich.jd01_06;

//import java.util.regex.Pattern;
//import java.util.regex.Matcher;
public class TaskB1 {
    public static void main(String[] args) {
        FindWord();
       }

    private static void FindWord(){
        String poema = Poem.text;
        char[] glasnye = {'А', 'а', 'Е','е', 'Ё', 'ё', 'И', 'и', 'О', 'о', 'У', 'у', 'Ы', 'ы', 'Э', 'э', 'Ю', 'ю', 'Я', 'я'};
        String[] slova = poema.split("[ !,.:\\t\\n\\x0B\\f\\r]");
        for (String slovo: slova) {
            if (slovo.length()>=2){
                char firstBukva = slovo.charAt(0);
                char lastBukva = slovo.charAt(slovo.length()-1);
                int findG1 = 0;
                int findG2 = 0;
                for (char el: glasnye) {
                    if (el == firstBukva){
                        findG1=1;
                        break;
                    }
                 }
                for (char el: glasnye) {
                    if (el == lastBukva){
                        findG2=1;
                        break;
                    }
                }
                if (findG1==0 && findG2==1) System.out.println(slovo);
             }

        }
    }




}
