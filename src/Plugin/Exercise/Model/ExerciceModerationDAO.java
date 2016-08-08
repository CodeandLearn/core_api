package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseModerationObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceModerationDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseModerationObj exerciseModerationObj = new ExerciseModerationObj();
        exerciseModerationObj.commentary = result.getString("commentary");
        exerciseModerationObj.exercice_id = result.getInt("exercice_id");
        exerciseModerationObj.moderation_validate_id = result.getInt("moderation_validate_id");
        return exerciseModerationObj;
    }

    public ExerciceModerationDAO getExerciceModeration(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT * FROM exercices_moderation WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceModerationDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getInt("moderation_validate_id"));
        make.add(jsonObject.getString("commentary"));
        setPost(SQL.make("INSERT INTO exercices_moderation (exercice_id, moderation_validate_id, commentary) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceModerationDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getInt("moderation_validate_id"));
        make.add(jsonObject.getString("commentary"));
        make.add(id);
        setPut(SQL.make("UPDATE exercices_moderation SET moderation_validate_id=?, commentary=? WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceModerationDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercices_moderation WHERE id=?", make.toArray()));
        return this;
    }
}
