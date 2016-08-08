package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Course.Obj.CourseCommentObj;

public class GetCourseComments extends Model {
    @Override
    protected Object setData(Map result) {
        CourseCommentObj courseCommentObj = new CourseCommentObj();
        courseCommentObj.account_id = result.getInt("account_id");
        courseCommentObj.content = result.getString("content");
        courseCommentObj.course_id = result.getInt("course_id");
        courseCommentObj.create_timestamp = result.getLong("create_timestamp");
        courseCommentObj.id = result.getInt("id");
        courseCommentObj.modify_timestamp = result.getLong("modify_timestamp");
        return courseCommentObj;
    }

    public GetCourseComments getCourseComments(String socket, int id_course) {
        make.add(id_course);
        setGet(SQL.make("SELECT * FROM courses_comments WHERE course_id=?", make.toArray()));
        return this;
    }
}
