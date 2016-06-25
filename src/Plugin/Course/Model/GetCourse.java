package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Course.Obj.CourseCommentObj;
import Plugin.Course.Obj.CourseObj;

import java.util.HashMap;

public class GetCourse extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            CourseObj courseObj = new CourseObj();
            courseObj.course.id = (Integer) result.get("courses.id");
            courseObj.course.account_id = (Integer) result.get("courses.account_id");
            courseObj.course.content = (String) result.get("courses.content");
            courseObj.course.create_timestamp = (Long) result.get("courses.create_timestamp");
            courseObj.course.language_id = (Integer) result.get("courses.language_id");
            courseObj.course.locales_id = (Integer) result.get("courses.locales_id");
            courseObj.course.modify_timestamp = (Long) result.get("courses.modify_timestamp");
            courseObj.course.title = (String) result.get("courses.title");
            SQLRequest commentSql = new SQLRequest("SELECT courses_comments.id\"courses_comments.id\",\n" +
                    "courses_comments.course_id\"courses_comments.course_id\",\n" +
                    "courses_comments.account_id\"courses_comments.account_id\",\n" +
                    "courses_comments.content\"courses_comments.content\",\n" +
                    "courses_comments.create_timestamp\"courses_comments.create_timestamp\",\n" +
                    "courses_comments.modify_timestamp\"courses_comments.modify_timestamp\"\n" +
                    "FROM courses_comments WHERE courses_comments.course_id=" + result.get("courses.id"));
            commentSql.select();
            for (HashMap<String, Object> comment : commentSql.getResultSet()) {
                CourseCommentObj courseCommentObj = new CourseCommentObj();
                courseCommentObj.account_id = (Integer) comment.get("courses_comments.account_id");
                courseCommentObj.content = (String) comment.get("courses_comments.content");
                courseCommentObj.course_id = (Integer) comment.get("courses_comments.course_id");
                courseCommentObj.create_timestamp = (Long) comment.get("courses_comments.create_timestamp");
                courseCommentObj.id = (Integer) comment.get("courses_comments.id");
                courseCommentObj.modify_timestamp = (Long) comment.get("courses_comments.modify_timestamp");
                courseObj.comments.add(courseCommentObj);
            }
            data.add(courseObj);
        }
    }

    public GetCourse getCourse(String socket) {
        setGet("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses ORDER BY courses.id ASC");
        return this;
    }

    public GetCourse getCourseWithId(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses WHERE courses.id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses ORDER BY courses.id ASC LIMIT ?", make.toArray()));
        return this;
    }

    public GetCourse getCourseByAuthorId(String socket, int author_id) {
        make.add(author_id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses WHERE courses.account_id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByLanguageId(String socket, int language_id) {
        make.add(language_id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses WHERE courses.language_id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByLocalesId(String socket, int locales_id) {
        make.add(locales_id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses WHERE courses.locales_id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByTitle(String socket, String title) {
        make.add(title);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\"\n" +
                "FROM courses WHERE courses.title=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }
}
