package Plugin.Course;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLPost;
import org.json.JSONObject;

public class PostCourseComment extends Model {
    public PostCourseComment(String socket, JSONObject jsonObject, int account_id) {
        long timestamp = System.currentTimeMillis();
        System.out.println(account_id);
        SQLite sql = new SQLite(SQLPost.COURSE_COMMENT + "(course_id, account_id, content, create_timestamp, modify_timestamp) VALUES ("
                + jsonObject.getInt("course_id") + ", "
                + account_id + ", "
                + "\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\", "
                + timestamp + ", "
                + timestamp + ")");
        sql.insert();
    }
}
