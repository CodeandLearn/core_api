package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Course.Obj.CourseCommentObj;

import java.util.HashMap;

public class GetCourseComments extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            CourseCommentObj courseCommentObj = new CourseCommentObj();
            courseCommentObj.account_id = (Integer) result.get("account_id");
            courseCommentObj.content = (String) result.get("content");
            courseCommentObj.course_id = (Integer) result.get("course_id");
            courseCommentObj.create_timestamp = (Long) result.get("create_timestamp");
            courseCommentObj.id = (Integer) result.get("id");
            courseCommentObj.modify_timestamp = (Long) result.get("modify_timestamp");
            data.add(courseCommentObj);
        }
    }

    public GetCourseComments getCourseComments(String socket, int id_course) {
        make.add(id_course);
        setGet(SQL.make("SELECT id, course_id, account_id, content, create_timestamp, modify_timestamp FROM courses_comments WHERE course_id=?", make.toArray()));
        return this;
    }
}
