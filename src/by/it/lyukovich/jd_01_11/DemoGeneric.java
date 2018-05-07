package by.it.lyukovich.jd_01_11;

import java.util.ArrayList;

    public class DemoGeneric {
        public static void main(String args[ ]) {
            ArrayList<String> list = new ArrayList<>();
            // ArrayList<int> b = new ArrayList<int>(); // ошибка компиляции
            list.add("Java"); /* компилятор "знает"
                                 допустимый тип передаваемого значения */
            list.add(1, "123");
            list.add(1, "12345");
            String res = list.get(0); /* компилятор "знает"
                                         допустимый тип возвращаемого значения */
            // list.add(new StringBuilder("C#")); // ошибка компиляции
            // компилятор не позволит добавить "посторонний" тип

            System.out.print(list); // удобный вывод
            System.out.println(list.get(2));
        }
}
