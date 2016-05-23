package Plugin.Account;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Data.SQLPost;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PostAccount extends Model {
    public PostAccount(String socket, JSONObject jsonObject) {
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
        setCode(Code.OK);
        //UserSecuritySingleton.getInstance().addUser();
    }
}
