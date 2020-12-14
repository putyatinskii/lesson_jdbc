import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public void create() {
        try (Connection con = Connect.connectDB()) {
            Statement statement = con.createStatement();
            String sqlCommand = "CREATE TABLE IF NOT EXISTS products (Id SERIAL PRIMARY KEY, " +
                    "ProductName VARCHAR(20), Price INT)";
            statement.executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void add() {
        try (Connection con = Connect.connectDB()) {
            Statement statement = con.createStatement();
            String sqlCommand = "INSERT INTO \"products\" " +
                    "VALUES (DEFAULT, 'phone5', 20000)";
            statement.executeUpdate(sqlCommand);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void get(int id) {
        try (Connection con = Connect.connectDB()) {
            Statement statement = con.createStatement();
            String sqlCommand = "SELECT * FROM \"products\" WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getAll() {
        try (Connection con = Connect.connectDB()) {
            Statement statement = con.createStatement();
            String sqlCommand = "SELECT * FROM \"products\"";
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.print(resultSet.getMetaData().getColumnLabel(i) + " ");
            }
            System.out.println();
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
