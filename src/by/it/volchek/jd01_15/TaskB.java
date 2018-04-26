//lkjlj
package by.it.volchek.jd01_15;
import java.io.*;

/**d
 * sdfsdf
 * sdf
 * sdf
 *
 */


public class TaskB {
    public static void main(String[] args) {
        String path = getPath (TaskB.class, "TaskB.java");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            StringBuilder sb = new StringBuilder();
            StringBuilder sbPart = new StringBuilder();
            String line;
            char[] chars;
            boolean flag = false;
            try {
                while ((line = bufferedReader.readLine())!=null){
                    if (line.isEmpty()) {
                        sb.append("\n");//ewrew
                        continue;
                        //werwqerqertetrwerewtewtewrt
                    }
                    chars=line.toCharArray();
                    /*sfdgdsgsdfgdsf
                    ff
                     */
                    for (int i = 0; i < chars.length; i++) {
                        if ((chars[i]=='/')&&(i!=chars.length-1)) {
                            if (chars[i+1]=='/')
                                break;

                        }
                        if ((chars[i]=='/')&&(i!=chars.length-1)) {
                            if (chars[i+1]=='*') {
                                flag = true;

                            }


                        }
                        if ((chars[i]=='*')&&(i!=chars.length-1)) {
                            if (chars[i+1]=='/')
                            {
                                flag = false;
                                i++;
                                continue;
                            }

                        }

                        if (!flag)
                            sbPart.append(chars[i]);

                    }
                    if (!sbPart.toString().equals("")){
                        sb.append(sbPart);
                        sb.append("\n");}
                    sbPart.setLength(0);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            path = getPath (TaskB.class, "TaskB.txt");
            try ( PrintWriter printer  = new PrintWriter (
                    new FileWriter(path)))
            {
                printer.print(sb);
                System.out.println(sb);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl)+filename;

    }
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;

    }
}
