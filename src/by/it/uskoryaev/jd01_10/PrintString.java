package by.it.uskoryaev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method [] method = stringClass.getDeclaredMethods();

        for (Method m :method) {
            if (!(Modifier.isStatic(m.getModifiers()))) {
                String res = m.getName().replaceAll("java.lang.String.", "");
                System.out.println(res);
            }

        }

    }
}
