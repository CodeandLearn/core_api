package Plugin.Course;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLPost;
import org.json.JSONObject;

public class PostCourse extends Model {
    public PostCourse(String socket, JSONObject jsonObject, int account_id) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPost.COURSE + "(account_id, locales_id, language_id, title, content, create_timestamp, modify_timestamp) VALUES ("
                + account_id + ", "
                + jsonObject.getInt("locales_id") + ", "
                + jsonObject.getInt("language_id") + ", "
                + "\"" + jsonObject.getString("title").replace("\"", "\\\"") + "\", "
                + "\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\", "
                + timestamp + ", "
                + timestamp + ")");
        sql.insert();
    }
}
