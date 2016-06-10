package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.CodeObj;
import Obj.ScriptObj;
import Obj.UserExerciseObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ScriptDAO extends Model {
    private final static String SQL_get = "SELECT id, exercice_id, content, create_timestamp, modify_timestamp FROM 'scripts' where exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'scripts' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'scripts' (exercice_id, content, create_timestamp, modify_timestamp) VALUES (?,?,?,?)";
    private final static String SQL_upd = "UPDATE 'scripts' set exercice_id=?, content=?, create_timestamp=?, modify_timestamp=? WHERE id=?";

    public ScriptDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("create_timestamp"));
        values.add(jsonObject.getLong("modify_timestamp"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        return this;
    }

    public ScriptDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("create_timestamp"));
        values.add(jsonObject.getLong("modify_timestamp"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        return this;
    }

    public ScriptDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        return this;
    }

    public ScriptDAO getExerciceScript(String socket, int exercice_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(exercice_id)));
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                ScriptObj scriptObj = new ScriptObj();
                scriptObj.content = (String) aResult.get("content");
                scriptObj.create_timestamp = (long) aResult.get("create_timestamp");
                scriptObj.exercise_id = (int) aResult.get("exercise_id");
                scriptObj.id = (int) aResult.get("id");
                scriptObj.modify_timestamp = (long) aResult.get("modify_timestamp");
                data.add(scriptObj);
            }
        }
        return this;
    }
}