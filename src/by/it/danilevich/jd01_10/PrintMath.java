package by.it.danilevich.jd01_10;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> strMath =Math.class;
        Method[] methods = strMath.getDeclaredMethods();

        Field[] fields = strMath.getFields();
        for (Field field : fields) {
            String rez = "";

            if (Modifier.isPublic(field.getModifiers())){
          //rez += "public ";
          //      if (Modifier.isProtected(field.getModifiers())) rez += "protected ";
          //      if (Modifier.isPrivate(field.getModifiers())) rez += "private ";
            //    if (Modifier.isStatic(field.getModifiers())) rez += "static ";
                rez += field.getType() + " " + field.getName();
                System.out.println(rez);
            }

        }

        for (Method method : methods ) {
            String rez = "";
            if (Modifier.isPublic(method.getModifiers())){
            rez += "public ";
           //if (Modifier.isProtected(method.getModifiers())) rez += "protected ";
           // if (Modifier.isPrivate(method.getModifiers())) rez += "private ";
            if (Modifier.isStatic(method.getModifiers())) rez += "static ";
            rez += method.getReturnType() + " " + method.getName() + "(";
            Class[] params=  method.getParameterTypes();
                 for (int i =0; i<params.length;i++) {
                     rez = rez.concat(params[i].getTypeName());
                     if (i!=(params.length-1)) rez += ",";
                 }
            rez +=")";
            System.out.println(rez);
             }

        }
    }


}
