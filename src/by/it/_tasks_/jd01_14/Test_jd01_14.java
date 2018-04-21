package by.it._tasks_.jd01_14;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_14 {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        Test_jd01_14 run = run("");
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(dir(Test_jd01_14.class) + "dataTaskA.bin"))
                );
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sb.append(i + " ");
                sum = sum + i;
                count++;
            }
            run.include(sb.toString().trim()); //проверка строки из 20 чисел
            run.include("avg=" + sum / count); //проверка вывода среднего арифметического

            Scanner scanner = new Scanner(new File(dir(Test_jd01_14.class) + "resultTaskA.txt"));
            //проверка соответсвия вывода и содержимого файла отчета resultTaskA.txt
            while (scanner.hasNext()) {
                run.include(scanner.nextLine());
            }
            scanner.close();
        }
    }

    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        Test_jd01_14 run = run("");
        run.include("words=157"); //слов должно быть 157
        run.include("marks=32");  //знаков должно быть 32 (исправлено 21.01.2018)
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        Scanner scanner = new Scanner(new File(dir(Test_jd01_14.class) + "resultTaskB.txt"));
        //проверка соответствия вывода и содержимого файла отчета resultTaskB.txt
        while (scanner.hasNext()) {
            run.include(scanner.nextLine());
        }
        scanner.close();
    }

    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        Test_jd01_14 run = run("");
        showDir(dir(Test_jd01_14.class)+"..",run);
        Scanner scanner = new Scanner(new File(dir(Test_jd01_14.class) + "resultTaskC.txt"));
        //проверка соответствия вывода и содержимого файла отчета resultTaskC.txt
        scanner.nextLine(); //пропуск dir:..
        while (scanner.hasNext()) {
            run.include(scanner.nextLine());
        }
        scanner.close();
    }

    private static void showDir(String path, Test_jd01_14 run) {
        File p = new File(path);
        if (p.isFile()) {
            run.include("file:" + p.getName());
        } else if (p.isDirectory()) {
            run.include("dir:" + p.getName());
            File[] paths = p.listFiles();
            if (paths != null)
                for (File iterator : paths) {
                    showDir(iterator.getAbsolutePath(),run);
                }
        }
    }

    static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
    }


    /*
    ===========================================================================================================
    НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
    Но изучить как он работает - можно, это всегда будет полезно.
    ===========================================================================================================
     */

    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nТест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    public Method checkMethod(String className, String methodName, Class<?>... parameters) throws Exception {
        Class aClass = this.findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = aClass.getDeclaredMethod(methodName, parameters);
                if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                    fail("\nМетод " + m.getName() + " должен быть статическим");
                }
            } else
                m = aClass.getDeclaredMethod(methodName, parameters);
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.print("\nНе найден метод " + methodName + " либо у него неверная сигнатура");
            System.err.print("\nОжидаемый класс: " + className);
            System.err.print("\nОжидаемый метод: " + methodName);
            return null;
        }
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Метод " + cl.getName() + "." + name + " не найден");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nНе удалось вызвать метод " + method.getName());
        }
        return null;
    }


    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    private static Test_jd01_14 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_14 run(String in, boolean runMain) {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = clName.replaceFirst(".+__", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_14(clName, in, runMain);
    }

    public Test_jd01_14() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_14(String className, String in, boolean runMain) {
        //this.className = className;
        aClass = null;
        try {
            aClass = Class.forName(className);
            this.className = className;

        } catch (ClassNotFoundException e) {
            fail("Не найден класс " + className);
        }
        reader = new StringReader(in); //заполнение ввода
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
        System.setIn(inputStream);   //перехват ввода

        System.setOut(newOut); //перехват стандартного вывода

        if (runMain) //если нужно запускать, то запустим, иначе оставим только вывод
            try {
                Class[] argTypes = new Class[]{String[].class};
                Method main = aClass.getDeclaredMethod("main", argTypes);
                main.invoke(null, (Object) new String[]{});
                System.setOut(oldOut); //возврат вывода, нужен, только если был запуск
            } catch (Exception x) {
                x.printStackTrace();
            }
    }

    //проверка вывода
    private Test_jd01_14 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_14 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_14 exclude(String str) {
        assertTrue("Лишние данные в выводе: " + str + "\n", !stringWriter.toString().contains(str));
        return this;
    }


    //переменные теста
    private StringWriter stringWriter = new StringWriter();
    private PrintStream oldOut = System.out;
    private StringReader reader;


    //поле для перехвата потока вывода
    private PrintStream newOut;

    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[2];

            @Override
            public void write(int b) throws IOException {
                if (b < 0) { //ловим и собираем двухбайтовый UTF (первый код > 127, или в байте <0)
                    if (bytes[0] == 0) { //если это первый байт
                        bytes[0] = (byte) b; //то запомним его
                    } else {
                        bytes[1] = (byte) b; //иначе это второй байт
                        String s = new String(bytes); //соберем весь символ
                        stringWriter.append(s); //запомним вывод для теста
                        oldOut.append(s); //копию в обычный вывод
                        bytes[0] = 0; //забудем все.
                    }
                } else {
                    char c = (char) b; //ловим и собираем однобайтовый UTF
                    bytes[0] = 0;
                    if (c != '\r') {
                        stringWriter.write(c); //запомним вывод для теста
                    }
                    oldOut.write(c); //копию в обычный вывод
                }
            }
        });
    }
}
