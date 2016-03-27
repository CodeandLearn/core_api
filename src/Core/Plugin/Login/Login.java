package Core.Plugin.Login;

import Core.Tool.SQLiteJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sheol on 07/03/2016.
 */
public class Login {
    private User[] users;

    public User[] getUser() {
        return users;
    }

    public void sqlgetUsers() throws SQLException {
        int i = 0;
        ResultSet result;
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        result = sql
                .selectDB("SELECT (SELECT COUNT(id) FROM accounts)'nb', * FROM accounts");
        if (result.getInt("nb") != 0) {
            users = new User[result.getInt("nb")];
            while (result.next()) {
                users[i] = new User();
                users[i].username = result.getString("username");
                users[i].password = result.getString("password");
                ++i;
            }
        }
        sql.closeDB();
    }
}
