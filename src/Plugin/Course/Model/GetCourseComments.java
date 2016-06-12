package Plugin.Course.Model;

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
            courseCommentObj.account_id = (Integer) result.get("courses_comments.account_id");
            courseCommentObj.content = (String) result.get("blog_posts_comments.content");
            courseCommentObj.course_id = (Integer) result.get("courses_comments.course_id");
            courseCommentObj.create_timestamp = (Long) result.get("courses_comments.create_timestamp");
            courseCommentObj.id = (Integer) result.get("courses_comments.id");
            courseCommentObj.modify_timestamp = (Long) result.get("courses_comments.modify_timestamp");
            data.add(courseCommentObj);
        }
    }
}
