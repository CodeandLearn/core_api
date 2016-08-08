package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseCorrectionObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCorrectionDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseCorrectionObj exerciseCorrectionObj = new ExerciseCorrectionObj();
        exerciseCorrectionObj.content = result.getString("content");
        exerciseCorrectionObj.exercice_id = result.getInt("exercice_id");
        exerciseCorrectionObj.id = result.getInt("id");
        return exerciseCorrectionObj;
    }

    public ExerciceCorrectionDAO getExerciceCorrection(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT * FROM exercices_corrections where exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceCorrectionDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO exercices_corrections (exercice_id, content, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceCorrectionDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE exercices_corrections SET exercice_id=?, content=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciceCorrectionDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercices_corrections WHERE id=?", make.toArray()));
        return this;
    }
}
