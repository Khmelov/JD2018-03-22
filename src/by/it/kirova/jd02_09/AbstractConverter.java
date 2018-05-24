package by.it.kirova.jd02_09;


import java.io.*;

abstract class AbstractConverter<T> {

    protected T data;
    protected String text;

    public String getText() {
        return text;
    }

    public abstract void load(String s);

    public void load(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            load(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            data = null;
        }
    }

    public abstract void convert();

    public void save(File file) {
        if (text == null)
            return;
        try (PrintWriter pr = new PrintWriter(new FileWriter(file))) {
            pr.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}