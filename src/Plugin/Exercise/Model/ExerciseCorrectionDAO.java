package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseCorrectionObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseCorrectionDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseCorrectionObj exerciseCorrectionObj = new ExerciseCorrectionObj();
        exerciseCorrectionObj.content = result.getString("exercises_corrections.content");
        exerciseCorrectionObj.exercise_id = result.getInt("exercises_corrections.exercise_id");
        exerciseCorrectionObj.id = result.getInt("exercises_corrections.id");
        return exerciseCorrectionObj;
    }

    public ExerciseCorrectionDAO getExerciseCorrection(int exercise_id) {
        make.add(exercise_id);
        setGet(SQL.make("SELECT * FROM exercises_corrections where exercise_id=?", make.toArray()));
        return this;
    }

    public ExerciseCorrectionDAO post(JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO exercises_corrections (exercise_id, content, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }
    public ExerciseCorrectionDAO post(JSONObject jsonObject, int e_id) {
        make.add(e_id);
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO exercises_corrections (exercise_id, content, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciseCorrectionDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE exercises_corrections SET exercise_id=?, content=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseCorrectionDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercises_corrections WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseCorrectionDAO deleteByExercise(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercises_corrections WHERE exercise_id=?", make.toArray()));
        return this;
    }
}
