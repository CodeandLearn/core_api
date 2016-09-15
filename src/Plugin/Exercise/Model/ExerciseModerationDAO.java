package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseModerationObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseModerationDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseModerationObj exerciseModerationObj = new ExerciseModerationObj();
        exerciseModerationObj.commentary = result.getString("exercises_moderation.commentary");
        exerciseModerationObj.exercise_id = result.getInt("exercises_moderation.exercise_id");
        exerciseModerationObj.moderation_validate_id = result.getInt("exercises_moderation.moderation_validate_id");
        return exerciseModerationObj;
    }

    public ExerciseModerationDAO getExerciseModeration(int exercise_id) {
        make.add(exercise_id);
        setGet(SQL.make("SELECT * FROM exercises_moderation WHERE exercise_id=?", make.toArray()));
        return this;
    }

    public ExerciseModerationDAO post(JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getInt("moderation_validate_id"));
        make.add(jsonObject.getString("commentary"));
        setPost(SQL.make("INSERT INTO exercises_moderation (exercise_id, moderation_validate_id, commentary) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public  ExerciseModerationDAO generate(int exercise_id){
        make.add(exercise_id);
        make.add(0);
        make.add("Content not reviewed yet");
        setPost(SQL.make("INSERT INTO exercises_moderation (exercise_id, moderation_validate_id, commentary) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }


    public ExerciseModerationDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getInt("moderation_validate_id"));
        make.add(jsonObject.getString("commentary"));
        make.add(id);
        setPut(SQL.make("UPDATE exercises_moderation SET moderation_validate_id=?, commentary=? WHERE exercise_id=?", make.toArray()));
        return this;
    }

    public ExerciseModerationDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercises_moderation WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseModerationDAO deleteByExercise(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercises_moderation WHERE exercise_id=?", make.toArray()));
        return this;
    }

}
