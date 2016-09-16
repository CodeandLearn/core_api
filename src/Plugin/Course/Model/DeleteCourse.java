package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;

public class DeleteCourse extends Model {
    public DeleteCourse deleteCourse(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM courses_comments WHERE course_id=?", make.toArray()));
        setDelete(SQL.make("DELETE FROM courses WHERE id=?", make.toArray()));
        return this;
    }

    public DeleteCourse deleteCourseComment(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM courses_comments WHERE id=?", make.toArray()));
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}
