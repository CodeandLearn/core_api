package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseDAO extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            ExerciseObj exerciseObj = new ExerciseObj();
            exerciseObj.account_id = (Integer) aResult.get("account_id");
            exerciseObj.course_id = (Integer) aResult.get("course_id");
            exerciseObj.grade_max = (Integer) aResult.get("grade_max");
            exerciseObj.id = (Integer) aResult.get("id");
            exerciseObj.instruction = (String) aResult.get("instruction");
            exerciseObj.title = (String) aResult.get("title");
            data.add(exerciseObj);
        }
    }

    public ExerciseDAO getCourseExercise(String socket, int course_id) {
        make.add(course_id);
        setGet(SQL.make("SELECT exercices.id, exercices.account_id, exercices.course_id, exercices.title, exercices.instruction, exercices.grade_max FROM exercices WHERE course_id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO getExerciseById(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT exercices.id, exercices.account_id, exercices.course_id, exercices.title, exercices.instruction, exercices.grade_max FROM exercices WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO getExercises(String socket) {
        setGet("SELECT exercices.id, exercices.account_id, exercices.course_id, exercices.title, exercices.instruction, exercices.grade_max FROM exercices");
        return this;
    }

    public ExerciseDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("account_id"));
        make.add(jsonObject.getInt("course_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("instruction"));
        make.add(jsonObject.getInt("grade_max"));
        setPost(socket, SQL.make("INSERT INTO exercices (account_id, course_id, title, instruction, grade_max) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciseDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("account_id"));
        make.add(jsonObject.getInt("course_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("instruction"));
        make.add(jsonObject.getInt("grade_max"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE exercices SET account_id=?, course_id=?, title=?, instruction=?, grade_max=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM exercices WHERE id=?", make.toArray()));
        return this;
    }
}
