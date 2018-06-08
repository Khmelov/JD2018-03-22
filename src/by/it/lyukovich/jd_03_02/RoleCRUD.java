package by.it.lyukovich.jd_03_02;

import java.sql.*;

class RoleCRUD {

    static boolean create(Role role) throws SQLException {
        boolean result;
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "INSERT INTO roles(roleid, rolename) VALUES (DEFAULT,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, role.getRole());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    role.setId(id);
                result = true;
                } else result =  false;
            }
        return result;
    }


    static boolean update(Role role) throws SQLException {
                try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "UPDATE roles SET rolename=? WHERE roleid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role.getRole());
            preparedStatement.setInt(2, role.getId());
            return (preparedStatement.execute());
        }
    }

    static boolean delete(Role role) throws SQLException {
         try (Connection connection = ConnectionCreator.getConnection()
        ) {
             String sql = "DELETE FROM roles WHERE roleid=?";
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, role.getId());
            return (preparedStatement.execute());
        }
    }

    static Role read(int roleid) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "SELECT * FROM roles WHERE roleid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, roleid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Role(
                        resultSet.getInt("roleid"),
                        resultSet.getString("rolename")
                );
            }
        }
        return null;
    }
}
