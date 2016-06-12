package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Model;
import org.json.JSONObject;

public class PostCourse extends Model {
    public PostCourse postCourse(String socket, int account_id, JSONObject jsonObject) {
        long timestamp = System.currentTimeMillis();
        make.add(account_id);
        make.add(jsonObject.getInt("locales_id"));
        make.add(jsonObject.getInt("language_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("content"));
        make.add(timestamp);
        make.add(timestamp);
        setPost(socket, SQL.make("INSERT INTO courses (account_id, locales_id, language_id, title, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public PostCourse postCourseComment(String socket, int account_id, JSONObject jsonObject) {
        long timestamp = System.currentTimeMillis();
        make.add(jsonObject.getInt("course_id"));
        make.add(account_id);
        make.add(jsonObject.getString("content"));
        make.add(timestamp);
        make.add(timestamp);
        setPost(socket, SQL.make("INSERT INTO courses_comments (course_id, account_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }
}
