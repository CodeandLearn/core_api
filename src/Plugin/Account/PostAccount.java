package Plugin.Account;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Data.SQLGet;
import Data.SQLPost;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PostAccount extends Model {
    public PostAccount(String socket, JSONObject jsonObject) {
        SQLite user = new SQLite(SQLGet.ACCOUNT_LOGIN + " AND accounts.username=" + "\"" + jsonObject.getString("username") + "\" OR email=" + "\"" + jsonObject.getString("email") + "\"");
        user.select();
        if (user.getResultSet().size() == 0) {
            long timestamp = System.currentTimeMillis();
            SQLite sql = new SQLite(SQLPost.ACCOUNT + "(username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercices_done) VALUES ("
                    + "\"" + jsonObject.getString("username") + "\", "
                    + "\"" + UserSecuritySingleton.hashString(jsonObject.getString("password")) + "\", "
                    + "\"" + jsonObject.getString("email") + "\", "
                    + 1 + ", "
                    + 1 + ", "
                    + timestamp + ", "
                    + timestamp + ", "
                    + 0 + ", "
                    + 0 + ")");
            sql.insert();
            setCode(socket, Code.OK);
            SQLite userId = new SQLite(SQLGet.ACCOUNT_LOGIN + " ORDER BY accounts.id DESC LIMIT 1");
            userId.select();
            for (int i = 0; i < userId.getResultSet().size(); i++) {
                UserSecuritySingleton.getInstance().addUser((int) userId.getResultSet().get(i).get("accounts.id"),
                        (String) userId.getResultSet().get(i).get("accounts.username"),
                        (String) userId.getResultSet().get(i).get("accounts.password"),
                        (int) userId.getResultSet().get(i).get("groups.parent_id"));
            }
        } else {
            setCode(socket, Code.INTERNAL_SERVER_ERROR);
        }
    }
}
