import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Dell on 14.03.2017.
 */
public class DBConnector {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DBConnector() {
        try {
            connection = DriverManager.getConnection(GlobalData.URL,
                    GlobalData.USERNAME,GlobalData.PASSWORD);

        } catch (SQLException e) {
            System.err.println("Failed");
        }
    }
}
