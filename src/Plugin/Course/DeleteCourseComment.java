package Plugin.Course;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLDelete;

public class DeleteCourseComment extends Model {
    public DeleteCourseComment(String socket, int id) {
        SQLite sql = new SQLite(SQLDelete.COURSE_COMMENT + "id=" + id);
        sql.delete();
        setCode(socket, Code.OK);
    }
}
