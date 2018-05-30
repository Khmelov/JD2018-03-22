package by.it.desykevich.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_Add_Data {

    public static void main(String[] args) {
        addData();
    }

    public static void addData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/desykevich" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                ""
        )) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `desykevich`.`ads` (`title`, `description`, `price`, `users_id`, `category_id`) " +
                    "VALUES ('Huawei P10  ', 'Android, экран 5.5\\\" IPS (1080x2280), HiSilicon Kirin 630, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 16 Мп, аккумулятор 3000 мАч, 2 SIM, цвет черный', 650, 2, 2);");
            System.out.println("Объявление Добавлено.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
