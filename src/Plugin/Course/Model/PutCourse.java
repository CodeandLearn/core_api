package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import org.json.JSONObject;

public class PutCourse extends Model {
    public PutCourse putCourse(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("locales_id"));
        make.add(jsonObject.getInt("language_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE courses SET locales_id=?, language_id=?, title=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public PutCourse putCourseComment(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE courses_comments SET content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}