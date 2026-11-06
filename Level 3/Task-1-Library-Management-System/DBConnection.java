import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/LibraryDB";

    private static final String USER = "root";

    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        try {
            if (PASSWORD == null || PASSWORD.isBlank()) {
                throw new SQLException("DB_PASSWORD is not configured.");
            }

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
