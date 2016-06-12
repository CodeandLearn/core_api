package Plugin.Course.Model;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLGet;
import Plugin.Course.Obj.CourseCommentObj;

public class GetCourseComments extends Model {
    public GetCourseComments(String socket) {
        setData(socket, "", "");
    }

    public GetCourseComments(String socket, String extra) {
        setData(socket, " AND " + extra, "");
    }

    public GetCourseComments(String socket, String extra, int limit) {
        if (!extra.equals("")) {
            setData(socket, " AND " + extra, " LIMIT " + limit);
        } else {
            setData(socket, "", " LIMIT " + limit);
        }
    }

    private void setData(String socket, String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.COURSE_COMMENT + " " + extra + " ORDER BY courses_comments.id DESC " + limit);
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        }
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            // DEBUG
            System.out.println(i + " - " + sql.getResultSet().get(i));
            // DEBUG
            CourseCommentObj courseCommentObj = new CourseCommentObj();
            courseCommentObj.account_id = (int) sql.getResultSet().get(i).get("courses_comments.account_id");
            courseCommentObj.content = (String) sql.getResultSet().get(i).get("blog_posts_comments.content");
            courseCommentObj.course_id = (int) sql.getResultSet().get(i).get("courses_comments.course_id");
            courseCommentObj.create_timestamp = (long) sql.getResultSet().get(i).get("courses_comments.create_timestamp");
            courseCommentObj.id = (int) sql.getResultSet().get(i).get("courses_comments.id");
            courseCommentObj.modify_timestamp = (long) sql.getResultSet().get(i).get("courses_comments.modify_timestamp");
            data.add(courseCommentObj);
        }
    }
}
