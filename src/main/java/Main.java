import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Dell on 14.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();

        String query = "select * from person";

        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setName(resultSet.getString("name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));

                System.out.println(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testConnect() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Failed to load driver");
        }

        try(Connection connection = DriverManager.getConnection(GlobalData.URL,GlobalData.USERNAME,GlobalData.PASSWORD);
            Statement statement = connection.createStatement()) {
            //statement.execute("INSERT INTO person (name,last_name,phone,email) VALUES ('German','Magay','8881','maga@mail');")
            //statement.executeUpdate("UPDATE person SET name = 'Dodik' WHERE id_person = 6;");
            //statement.executeQuery("SELECT *FROM person;");

            statement.addBatch("INSERT INTO person (name,last_name,phone,email) VALUES ('Viktor','Circuitin','8811','viktor@mail');");
            statement.addBatch("INSERT INTO person (name,last_name,phone,email) VALUES ('Anatoliy','Marginal','8381','anatoliy@mail');");
            statement.addBatch("INSERT INTO person (name,last_name,phone,email) VALUES ('Yan','Picture','8851','yan@mail');");

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
