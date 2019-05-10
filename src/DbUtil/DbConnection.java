package DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection connection = getConnection();

    private static Connection getConnection() {
        final String DRIVER_NAME = "org.sqlite.JDBC";
        final String CONNECT_STRING = "jdbc:sqlite:C://Program Files//SQLiteStudio//przychodnia.db";
        try {
            Class.forName(DRIVER_NAME);
            return DriverManager.getConnection(CONNECT_STRING);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
