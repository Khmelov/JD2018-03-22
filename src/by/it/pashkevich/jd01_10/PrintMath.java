package by.it.pashkevich.jd01_10;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = Math.class.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())){
                sb.append(Modifier.toString(method.getModifiers()));
                sb.append(" ").append(method.getGenericReturnType());
                sb.append(" ").append(method.getName());
                sb.append(Arrays.toString(method.getParameterTypes())
                        .replace('[','(')
                        .replace(']',')')
                        .replace(" ","")).append("\n");
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())){
                sb.append(Modifier.toString(field.getModifiers()));
                sb.append(" ").append(field.getType());
                sb.append(" ").append(field.getName()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
