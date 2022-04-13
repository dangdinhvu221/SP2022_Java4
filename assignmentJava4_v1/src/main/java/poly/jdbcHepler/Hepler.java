package poly.jdbcHepler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hepler {
    static final String jdbcURL = "jdbc:sqlserver://localhost;database=AssignmentJava4";
    static final String dbUser = "sa";
    static final String dbPassword = "123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException el) {
            el.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
