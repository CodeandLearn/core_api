package Plugin.Course;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLGet;
import Obj.CourseCommentObj;

public class GetCourse extends Model {
    public GetCourse(String socket) {
        setData(socket, "", "");
    }

    public GetCourse(String socket, String extra) {
        setData(socket, " WHERE " + extra, "");
    }

    public GetCourse(String socket, String extra, int limit) {
        if (!extra.equals("")) {
            setData(socket, " WHERE " + extra, " LIMIT " + limit);
        } else {
            setData(socket, "", " LIMIT " + limit);
        }
    }

    private void setData(String socket, String extra, String limit) {
        System.out.println(SQLGet.COURSE + " " + extra + " ORDER BY courses.id DESC " + limit);
        SQLite sql = new SQLite(SQLGet.COURSE + " " + extra + " ORDER BY courses.id DESC " + limit);
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (int i = 0; i < sql.getResultSet().size(); i++) {
                // DEBUG
                System.out.println(i + " - " + sql.getResultSet().get(i));
                // DEBUG
                CourseObj courseObj = new CourseObj();
                courseObj.course.id = (int) sql.getResultSet().get(i).get("courses.id");
                courseObj.course.account_id = (int) sql.getResultSet().get(i).get("courses.account_id");
                courseObj.course.content = (String) sql.getResultSet().get(i).get("courses.content");
                courseObj.course.create_timestamp = (long) sql.getResultSet().get(i).get("courses.create_timestamp");
                courseObj.course.language_id = (int) sql.getResultSet().get(i).get("courses.language_id");
                courseObj.course.locales_id = (int) sql.getResultSet().get(i).get("courses.locales_id");
                courseObj.course.modify_timestamp = (long) sql.getResultSet().get(i).get("courses.modify_timestamp");
                courseObj.course.title = (String) sql.getResultSet().get(i).get("courses.title");
                SQLite commentSql = new SQLite(SQLGet.COURSE_COMMENT + " AND courses_comments.course_id=" + sql.getResultSet().get(i).get("courses.id"));
                commentSql.select();
                for (int x = 0; x < commentSql.getResultSet().size(); x++) {
                    // DEBUG
                    System.out.println(x + " - " + commentSql.getResultSet().get(x));
                    // DEBUG
                    CourseCommentObj courseCommentObj = new CourseCommentObj();
                    courseCommentObj.account_id = (int) commentSql.getResultSet().get(x).get("courses_comments.account_id");
                    courseCommentObj.content = (String) commentSql.getResultSet().get(x).get("blog_posts_comments.content");
                    courseCommentObj.course_id = (int) commentSql.getResultSet().get(x).get("courses_comments.course_id");
                    courseCommentObj.create_timestamp = (long) commentSql.getResultSet().get(x).get("courses_comments.create_timestamp");
                    courseCommentObj.id = (int) commentSql.getResultSet().get(x).get("courses_comments.id");
                    courseCommentObj.modify_timestamp = (long) commentSql.getResultSet().get(x).get("courses_comments.modify_timestamp");
                    courseObj.comments.add(courseCommentObj);
                }
                data.add(courseObj);
            }
        }
    }
}
