package by.it.akhmelev.jd01_06;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA2 {
    public static void main(String[] args) {
        Pattern p=Pattern.compile("[А-яЁё]+");
        Matcher m=p.matcher(Poem.text);
        HashMap<String,Integer> hm=new HashMap<>();
        while (m.find()){
            if (hm.containsKey(m.group())){
                hm.put(m.group(),hm.get(m.group())+1);
            }
            else
                hm.put(m.group(),1);
        }
        System.out.println(hm);
    }
}
