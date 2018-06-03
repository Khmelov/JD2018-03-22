package by.it.danilevich.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskC {
    public static void deleteDateBase(){
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();)
        {
            statement.executeUpdate(InitBase.deleteSchema);
            System.out.println("Delete dateBase");
        }
        catch (SQLException e1) {

            e1.printStackTrace();
        }

    }

    public static void createDateBase() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();)
        {
//            statement.executeUpdate("use " + CN.NAME_DB);
            statement.executeUpdate(InitBase.createSchema);
            statement.executeUpdate(InitBase.createRole);
            statement.executeUpdate(InitBase.createKindofWork);
            statement.executeUpdate(InitBase.createUser);
            statement.executeUpdate(InitBase.createOrder);

            statement.executeUpdate(InitBase.insertRole);
            statement.executeUpdate(InitBase.insertUser);
            statement.executeUpdate(InitBase.insertKindOfWork);
            statement.executeUpdate(InitBase.insertOrder);
            System.out.println("Create dateBase");
            }
    }
}
