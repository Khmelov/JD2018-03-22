package by.it.lyukovich.jd_02_05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
//Конвертирует все текстовые файлы, содержащие признак locale
public class Converter {
    public static Path path = Paths.get(getPath(Converter.class));
    public static void main(String[] args) throws IOException {
        for (File file : getFiles(path)){
            if(file.getName().endsWith(".txt") && file.getName().contains("locale")){
                BufferedReader br = new BufferedReader(new FileReader(file));
                try {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    while (line != null) {
                        sb.append(convertLine(line));
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    String result = sb.toString();
                    fileWriter(result, file.getName().replace(".txt",".properties"));
                } finally {
                    br.close();
                }
                System.out.println(file.getName().toString() + " сконвертирован");
            }
        }
    }

    private static String getPath(Class<?> cl) { //Путь текущего каталога
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    private static List<File> getFiles(Path path){ //Получает список файлов в текущем каталоге
        List<File> filesInFolder=null;
        try {
            filesInFolder = Files.walk(Paths.get(path.toString()))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filesInFolder;
    }
    private static String convertLine (String string){ //Конвертирует строку в ascii
        String result = string.substring(0, string.indexOf("="));
        for (int i = string.indexOf("="); i < string.length(); i++) {
            final char ch = string.charAt(i);
            if (ch <= 127) result+=ch; else
                result+="\\u" + String.format("%04x", (int)ch);
        }
        return result;
    }
    private static void fileWriter(String s, String fileName) //Запись в файл .properties
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString() + File.separator + fileName));
        writer.write(s);
        writer.close();
    }
}
