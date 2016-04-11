package Core.Tools;

import java.sql.*;

/**
 * Created by teddy on 11/04/2016.
 */
public class MySQLJDBC extends SQL {
    public MySQLJDBC(String dbName, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName + "?" + "user=" + username + "&password=" + password);
            stmt = c.createStatement();
            c.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
