package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseModerationObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceModerationDAO extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            ExerciseModerationObj exerciseModerationObj = new ExerciseModerationObj();
            exerciseModerationObj.commentary = (String) aResult.get("commentary");
            exerciseModerationObj.exercise_id = (Integer) aResult.get("exercise_id");
            exerciseModerationObj.moderation_validate_id = (Integer) aResult.get("moderation_validate_id");
            data.add(exerciseModerationObj);
        }
    }

    public ExerciceModerationDAO getExerciceModeration(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT exercice_id, moderation_validate_id, commentary FROM exercices_moderation WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceModerationDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("moderation_validate_id"));
        make.add(jsonObject.getLong("commentary"));
        setPost(socket, SQL.make("INSERT INTO exercices_moderation (exercice_id, moderation_validate_id, commentary) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceModerationDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("moderation_validate_id"));
        make.add(jsonObject.getLong("commentary"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE exercices_moderation SET moderation_validate_id=?, commentary=? WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceModerationDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM exercices_moderation WHERE id=?", make.toArray()));
        return this;
    }
}
