package Core.Plugin.Login;

import Core.Tool.SQLiteJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sheol on 07/03/2016.
 */
public class Login {
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUser() {
        return users;
    }

    public void sqlgetUsers() throws SQLException {
        ResultSet result;
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        result = sql.selectDB("SELECT * FROM accounts");
        while (result.next()) {
            User user = new User();
            user.username = result.getString("username");
            user.password = result.getString("password");
            users.add(user);
        }
        sql.closeDB();
    }
}
