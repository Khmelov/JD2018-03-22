package by.it.sgolovach.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA_AddData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/sgolovach", "root", "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 3, 13699, 32, 1, 2, 'Minsk, Brikete 2', 3)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'buy flat', 8, 132000, 168, 25, 25, 'Moscow, Sgukova 1', 1)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 2, 25000, 15, 1, 2, 'Gomel, Brikete 8', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'buy flat in Minsk,Grodno', 3, 63000, 89, 2, 9, 'Minsk,Grodno', 5)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 3, 35450, 92, 5, 5, 'Mogilev, Lomonosova 26', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 2, 27989, 76, 2, 5, 'Mogilev, Lenina 15', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'buy flat in Minsk', 6, 95000, 127, 3, 5, 'Minsk, Pobediteley 13', 6)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 2, 95630, 56, 7, 9, 'Minsk, Filimonova 35', 3)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat in Varshava Poland', 3, 38900, 68, 4, 5, 'Varshava, Kastushki 92', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat in London UK', 4, 136900, 127, 29, 35, 'London, Picadili 6/2', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 5, 35600, 125, 2, 5, 'Vitebsk, Chepelia 39', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 3, 29365, 98, 7, 10, 'Minsk, Suharevo 85', 3)");
            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
