import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/Lesson";
        String login = "postgres";
        String password = "341678";
        return DriverManager.getConnection(url, login, password);
    }
}
