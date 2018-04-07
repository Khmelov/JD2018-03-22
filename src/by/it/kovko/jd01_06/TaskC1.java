package by.it.kovko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text+"\n");
        Pattern newLine = Pattern.compile("\n");
        Matcher m = newLine.matcher(poem);
        int numOfLines=(poem.length()-m.replaceAll("").length());
        StringBuilder lines[] = new StringBuilder[numOfLines];
        int i=0, prevStart=0, maxLength=0, lineLength;
        m.reset();
        while (m.find()){
            lines[i]=new StringBuilder(poem.substring(prevStart,m.start()));
            lineLength=lines[i].length();
            if (maxLength<lineLength)
                maxLength=lineLength;
            prevStart=m.end();
            ++i;
        }

        Pattern space = Pattern.compile("[ ]+");
        int spaceStart;
        for (StringBuilder line : lines) {
            m = space.matcher(line);
            spaceStart=0;
            while (line.length()<maxLength){
                if (!m.find(spaceStart))
                    m.find(0);
                spaceStart=m.start()+m.group().length();
                line.insert(spaceStart++,' ');
            }
        }

        for (StringBuilder line : lines) {
            System.out.print(line.toString()+'\n');
        }
    }
}
