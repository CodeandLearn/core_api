package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseCorrectionObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCorrectionDAO extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            ExerciseCorrectionObj exerciseCorrectionObj = new ExerciseCorrectionObj();
            exerciseCorrectionObj.content = (String) aResult.get("content");
            exerciseCorrectionObj.exercise_id = (Integer) aResult.get("exercice_id");
            exerciseCorrectionObj.id = (Integer) aResult.get("id");
            data.add(exerciseCorrectionObj);
        }
    }

    public ExerciceCorrectionDAO getExerciceCorrection(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT id, exercice_id, content, exercices_corrections.timestamp FROM exercices_corrections where exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceCorrectionDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(jsonObject.getLong("timestamp"));
        setPost(socket, SQL.make("INSERT INTO exercice_corrections (exercice_id, content, exercices_corrections.timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceCorrectionDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(jsonObject.getLong("timestamp"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE exercice_corrections SET exercice_id=?, content=?, exercices_corrections.timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciceCorrectionDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM exercices_corrections WHERE id=?", make.toArray()));
        return this;
    }
}
