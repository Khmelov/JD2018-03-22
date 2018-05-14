package by.it.kovko.jd02_05;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class MakeProperties {
    private static String path = getPath(MakeProperties.class);
//    private String outputPath = "fromtxt2";
//    private String inputPath = "txt";//\\Message.txt";

    void createProperties(String inputPath, String outputPath){
        File inputDir = new File(path+File.separator+ inputPath);
        File outputDir = new File (path+File.separator+ outputPath);
        if (inputDir.exists() && inputDir.isDirectory()){
            for (File file : inputDir.listFiles()) {
                if (file.getName().endsWith(".txt")) {
                    StringBuilder inputSB = new StringBuilder();
                    try (BufferedReader br = new BufferedReader(
                            new FileReader(file))){
                        String line="";
                        while((line=br.readLine())!=null)
                            inputSB.append(line+'\n');
                        br.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    StringBuilder outputSB = new StringBuilder();
                    try (BufferedWriter bw = new BufferedWriter(
                            new FileWriter(outputDir+File.separator+file.getName()
                                    .replace(".txt",".properties")))){
                        for (char c : inputSB.toString().toCharArray()) {
                            if ((int)c>127)
                                outputSB.append(String.format("\\u"+"%04x",(int)c));
                            else
                                outputSB.append(c);
                        }
                        bw.write(outputSB.toString());
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Properties has been created successfully");
    }

    static String getPath(Class<?> cl, String filename) {
    return getPath(cl)+filename;
}
    static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path+=(File.separator+"src"+File.separator);
        path+=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path;
    }
}
