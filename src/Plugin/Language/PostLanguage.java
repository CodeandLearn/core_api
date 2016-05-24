package Plugin.Language;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLPost;
import org.json.JSONObject;

/**
 * Created by Fabien on 06/05/2016.
 */
public class PostLanguage extends Model {
    public PostLanguage(String socket, JSONObject jsonObject) {
        SQLite sql = new SQLite(SQLPost.LANGUAGE + "(name) VALUES ("
                + jsonObject.getString("name").replace("\"", "\\\"") + ")");
        sql.insert();
        setCode(socket, Code.OK);
    }
}
