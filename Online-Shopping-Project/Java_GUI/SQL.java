package Java_GUI;

import java.sql.*;

// Done
public class SQL {
    private Statement statement;

    public SQL() throws SQLException {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            System.out.println("Driver registered successfully.");
        } catch (Exception cnfe) {
            System.out.println("Class not found");
            throw new SQLException("Failed to register driver.", cnfe);
        }

        String url = "jdbc:postgresql://localhost:5432/shop";
        Connection con = DriverManager.getConnection(url, "postgres", "123");
        statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("Build connection with database successfully");
    }

    public void WriteExcute(String sqlCode) {
        try {
            statement.executeUpdate(sqlCode);
            System.out.println("Write executed: " + sqlCode);
        } catch (SQLException e) {
            int errorCode = e.getErrorCode(); // Get SQLCODE
            String sqlState = e.getSQLState(); // Get SQLSTATE
            System.out.println("Code: " + sqlCode + "  SQLState: " + sqlState);
        }
    }

    public ResultSet QueryExchte(String sqlCode) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sqlCode);
            System.out.println("Query executed: " + sqlCode);
        } catch (SQLException e) {
            int errorCode = e.getErrorCode(); // Get SQLCODE
            String sqlState = e.getSQLState(); // Get SQLSTATE
            System.out.println("Code: " + sqlCode + "  SQLState: " + sqlState);
        }
        return rs;
    }
}
