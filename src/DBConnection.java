import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String dbUrl = "jdbc:postgresql://localhost:5411/lab8_db";
    private static final String dbUser = "postgres";
    private static final String dbPassword = "1324";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            if (connection != null) {
                System.out.println("Connected");
            } else {
                throw new SQLException("Could not connect to PostgreSQL database");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return connection;
    }
}
