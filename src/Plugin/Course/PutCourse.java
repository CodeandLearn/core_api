package Plugin.Course;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLPut;
import org.json.JSONObject;

public class PutCourse extends Model {
    public PutCourse(String socket, int id, JSONObject jsonObject) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPut.COURSE
                + ", locales_id=" + jsonObject.getInt("locales_id")
                + ", language_id=" + jsonObject.getInt("language_id")
                + ", title=\"" + jsonObject.getString("title").replace("\"", "\\\"") + "\""
                + ", content=\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\""
                + ", modify_timestamp=" + timestamp
                + " WHERE id=" + id);
        sql.update();
        setCode(socket, Code.OK);
    }
}