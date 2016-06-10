package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutAccount extends Model {
    public PutAccount putAccount(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("username"));
        make.add(UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
        make.add(jsonObject.getString("email"));
        make.add(jsonObject.getInt("group_id"));
        make.add(jsonObject.getInt("avatar_id"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE accounts SET username=?, password=?, email=?, group_id=?, avatar_id=? WHERE id=?", make.toArray()));
        UserSecuritySingleton.getInstance().updateFullUser(socket, jsonObject.getString("username"),
                UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
        UserSecuritySingleton.getInstance().revokUserToken(socket);
        return this;
    }
}
