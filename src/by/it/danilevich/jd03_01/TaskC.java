package by.it.danilevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

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
            statement.executeUpdate(InitBase.createCurrency);
            statement.executeUpdate(InitBase.createCategory);
            statement.executeUpdate(InitBase.createUnits);
            statement.executeUpdate(InitBase.createStatusWork);
            statement.executeUpdate(InitBase.createRoles);
            statement.executeUpdate(InitBase.createKindofWork);
            statement.executeUpdate(InitBase.createUsers);
            statement.executeUpdate(InitBase.createOrder);

            statement.executeUpdate(InitBase.insertCurrency);
            statement.executeUpdate(InitBase.insertCategory);
            statement.executeUpdate(InitBase.insertUnits);
            statement.executeUpdate(InitBase.insertStatus);
            statement.executeUpdate(InitBase.insertRoles);
            statement.executeUpdate(InitBase.insertUsers);
            statement.executeUpdate(InitBase.insertKindOfWork);
            statement.executeUpdate(InitBase.insertOrder);
            System.out.println("Create dateBase");
            }
    }
}
