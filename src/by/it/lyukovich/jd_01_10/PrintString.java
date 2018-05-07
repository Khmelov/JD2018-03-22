package by.it.lyukovich.jd_01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SuppressWarnings("ALL")
public class PrintString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Class strclass = String.class;
        Method[] methods = strclass.getDeclaredMethods();
        //1-й вариант
        for (Method method : methods){
            if (!(Modifier.isStatic(method.getModifiers()))) {
            if (sb.toString().contains(method.getName().toString())) {
            } else sb.append(method.getName()).append("\n");}}
        System.out.println(sb);

        //2-й вариант проверки через бул
        /*for (Method m : methods) {
            if (!(getModifiers(m.getModifiers()))){
                {if (sb.toString().contains(m.getName().toString())) {
                } else sb.append(m.getName()).append("\n");}}
        }
        System.out.println(sb);*/
    }
    static boolean getModifiers(int m) {
        if (Modifier.isStatic(m)){
        return true;}else return false;
    }
 }
