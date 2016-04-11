package Core.Tools;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by teddy on 11/04/2016.
 */
public class MongoDBJDBC extends SQL {
    public MongoDBJDBC(String dbName, String username) {
        try {
            Class.forName("mongodb.jdbc.MongoDriver");
            c = DriverManager.getConnection("jdbc:mongo://ds029847.mongolab.com:29847/" + dbName, username, username);
            stmt = c.createStatement();
            c.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
