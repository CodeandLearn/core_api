package Plugin.Course;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLPut;
import org.json.JSONObject;

public class PutCourseComment extends Model {
    public PutCourseComment(String socket, int id, JSONObject jsonObject) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPut.COURSE_COMMENT
                + "content=\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\""
                + "modify_timestamp=" + timestamp
                + " WHERE id=" + id);
        sql.update();
    }
}