package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Model;

public class DeleteCourse extends Model {
    public DeleteCourse deleteCourse(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM courses_comments WHERE course_id=?", make.toArray()));
        setDelete(socket, SQL.make("DELETE FROM courses WHERE id=?", make.toArray()));
        return this;
    }

    public DeleteCourse deleteCourseComment(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM courses WHERE id=?", make.toArray()));
        return this;
    }
}
