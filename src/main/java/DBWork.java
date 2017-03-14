import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Dell on 14.03.2017.
 */
public class DBWork {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBWork() {
        try {
            connection = DriverManager.getConnection(GlobalData.URL,GlobalData.USERNAME,GlobalData.PASSWORD);

        } catch (SQLException e) {
            System.err.println("Failed");
        }
    }
}
