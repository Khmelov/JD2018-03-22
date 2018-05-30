package by.it.desykevich.jd03_02;

import by.it.desykevich.jd03_02.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

class AdCRUD {

     static boolean create(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `ads` (`title`,  `description`, `price`, `users_id`, `category_id`) " +
                            "VALUES ('%s', '%s', '%d', '%d', '%d');",
                    ad.getTitle(),ad.getDescription(),
                    ad.getPrice(),ad.getUsers_Id(),ad.getCategory_Id());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    ad.setId(id);
                }
            }
            return recCount == 1;
        }
    }

     static boolean update(Ad ad) throws SQLException {
         String sql = String.format(Locale.US, "UPDATE `ads` SET title='%s', description='%s', " +
                         "price='%d', users_id='%d', category_id='%d' WHERE id='%d';",
                 ad.getTitle(),ad.getDescription(),
                 ad.getPrice(),ad.getUsers_Id(),ad.getCategory_Id(),ad.getId());
         try (Connection connection = ConnectionCreator.getConnection();
              Statement statement = connection.createStatement()
         ) {
             return (1 == statement.executeUpdate(sql));
         }
    }

     static Ad read(int ID) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("SELECT * FROM `ads` WHERE id=%d;", ID);
            ResultSet result = statement.executeQuery(query);
            if (result.next()){
                return new Ad(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("description"),
                        result.getInt("price"),
                        result.getInt("users_Id"),
                        result.getInt("category_Id"));
            }
        }
        return null;
    }

    static boolean delete(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM ads WHERE id=%d;", ad.getId());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }
}
