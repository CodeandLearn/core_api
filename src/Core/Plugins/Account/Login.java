package Core.Plugins.Account;

import Core.Datas.SQLGet;
import Core.Objs.AccountObj;
import Core.Tools.SQLiteJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sheol on 07/03/2016.
 */
public class Login {
    private ArrayList<AccountObj> accountObjs = new ArrayList<>();

    public ArrayList<AccountObj> getUser() {
        return accountObjs;
    }

    public void sqlGetUsers() throws SQLException {
        ResultSet result;
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        result = sql.selectDB(SQLGet.ACCOUNT_LOGIN);
        while (result.next()) {
            AccountObj accountObj = new AccountObj();
            accountObj.id = result.getInt("accounts.id");
            accountObj.group_id = result.getInt("accounts.group_id");
            accountObj.email = result.getString("accounts.email");
            accountObj.username = result.getString("accounts.username");
            accountObj.password = result.getString("accounts.password");
            accountObjs.add(accountObj);
        }
        sql.closeDB();
    }
}
