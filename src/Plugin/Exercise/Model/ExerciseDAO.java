package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseObj exerciseObj = new ExerciseObj();
        exerciseObj.account_id = result.getInt("account_id");
        exerciseObj.course_id = result.getInt("course_id");
        exerciseObj.grade_max = result.getInt("grade_max");
        exerciseObj.id = result.getInt("id");
        exerciseObj.instruction = result.getString("instruction");
        exerciseObj.title = result.getString("title");
        return exerciseObj;
    }

    public ExerciseDAO getCourseExercise(String socket, int course_id) {
        make.add(course_id);
        setGet(SQL.make("SELECT * FROM exercices WHERE course_id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO getExerciseById(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM exercices WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO getExercises(String socket) {
        setGet("SELECT * FROM exercices");
        return this;
    }

    public ExerciseDAO post(String socket, int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("course_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("instruction"));
        make.add(jsonObject.getInt("grade_max"));
        setPost(SQL.make("INSERT INTO exercices (account_id, course_id, title, instruction, grade_max) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciseDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("course_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("instruction"));
        make.add(jsonObject.getInt("grade_max"));
        make.add(id);
        setPut(SQL.make("UPDATE exercices SET course_id=?, title=?, instruction=?, grade_max=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercices WHERE id=?", make.toArray()));
        return this;
    }
}
