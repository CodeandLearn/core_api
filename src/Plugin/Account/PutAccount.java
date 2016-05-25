package Plugin.Account;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Data.SQLPut;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutAccount extends Model {
    public PutAccount(String socket, int id, JSONObject jsonObject) {
        SQLite sql = new SQLite(SQLPut.ACCOUNT
                + "username=\"" + jsonObject.getString("username") + "\", "
                + "password=\"" +  UserSecuritySingleton.hashString(jsonObject.getString("password")) + "\", "
                + "email=\"" + jsonObject.getString("email") + "\", "
                + "group_id=" + jsonObject.getInt("group_id")
                + ", avatar_id=" + jsonObject.getInt("avatar_id")
                + " WHERE id=" + id);
        sql.update();
        setNoReturnValue(socket);
        UserSecuritySingleton.getInstance().updateFullUser(socket, jsonObject.getString("username"),
                UserSecuritySingleton.hashString(jsonObject.getString("password")));
        UserSecuritySingleton.getInstance().revokUserToken(socket);
    }
}
