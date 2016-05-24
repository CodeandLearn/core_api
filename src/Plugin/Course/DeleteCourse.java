package Plugin.Course;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLDelete;

public class DeleteCourse extends Model {
    public DeleteCourse(String socket, int id) {
        SQLite sql_com = new SQLite(SQLDelete.COURSE_COMMENT + "course_id=" + id);
        SQLite sql_post = new SQLite(SQLDelete.COURSE + "id=" + id);
        sql_com.delete();
        sql_post.delete();
        setCode(socket, Code.OK);
    }
}
