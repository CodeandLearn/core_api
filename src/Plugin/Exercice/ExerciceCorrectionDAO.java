package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.CodeObj;
import Obj.ExerciseCorrectionObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCorrectionDAO extends Model {
    private final static String SQL_get = "SELECT id, exercice_id, content, exercices_corrections.timestamp FROM 'exercices_corrections' where exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'exercices_corrections' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'exercice_corrections' (exercice_id, content, exercices_corrections.timestamp) VALUES (?,?,?)";
    private final static String SQL_upd = "UPDATE 'exercice_corrections' set exercice_id=?, content=?, exercices_corrections.timestamp=? WHERE id=?";

    public ExerciceCorrectionDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("timestamp"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciceCorrectionDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("timestamp"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciceCorrectionDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciceCorrectionDAO getExerciceCorrection(String socket, int exercice_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(exercice_id)));
        sql.delete();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                ExerciseCorrectionObj exerciseCorrectionObj = new ExerciseCorrectionObj();
                exerciseCorrectionObj.content = (String) aResult.get("content");
                exerciseCorrectionObj.exercise_id = (int) aResult.get("exercice_id");
                exerciseCorrectionObj.id = (int) aResult.get("id");
                data.add(exerciseCorrectionObj);
            }
        }
        return this;
    }
}
