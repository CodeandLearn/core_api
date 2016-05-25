package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.ExerciseModerationObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceModerationDAO extends Model {
    private final static String SQL_get = "SELECT exercice_id, moderation_validate_id, commentary FROM 'exercices_moderation' where exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'exercices_moderation' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'exercices_moderation' (exercice_id, moderation_validate_id, commentary) VALUES (?,?,?)";
    private final static String SQL_upd = "UPDATE 'exercices_moderation' set moderation_validate_id=?, commentary=? WHERE exercice_id=?";

    public ExerciceModerationDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getString("moderation_validate_id"));
        values.add(jsonObject.getLong("commentary"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciceModerationDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getString("moderation_validate_id"));
        values.add(jsonObject.getLong("commentary"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciceModerationDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciceModerationDAO getExerciceModeration(String socket, int exercice_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(exercice_id)));
        sql.delete();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                ExerciseModerationObj exerciseModerationObj = new ExerciseModerationObj();
                exerciseModerationObj.commentary = (String) aResult.get("commentary");
                exerciseModerationObj.exercise_id = (int) aResult.get("exercise_id");
                exerciseModerationObj.moderation_validate_id = (int) aResult.get("moderation_validate_id");
                data.add(exerciseModerationObj);
            }
        }
        return this;
    }
}
