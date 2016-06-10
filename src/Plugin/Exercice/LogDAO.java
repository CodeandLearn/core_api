package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.CodeObj;
import Obj.LogObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class LogDAO extends Model {
    private final static String SQL_get = "SELECT id, user_exercice_id, content, logs.timestamp FROM 'logs' where user_exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'logs' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'logs' (user_exercice_id, content, logs.timestamp) VALUES (?,?,?)";
    private final static String SQL_upd = "UPDATE 'logs' set user_exercice_id=?, content=?, logs.timestamp=? WHERE id=?";

    public LogDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("user_exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("logs.timestamp"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        return this;
    }

    public LogDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("user_exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("logs.timestamp"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        return this;
    }

    public LogDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        return this;
    }

    public LogDAO getLog(String socket, int user_exercice_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(user_exercice_id)));
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                LogObj logObj = new LogObj();
                logObj.content = (String) aResult.get("content");
                logObj.id = (int) aResult.get("id");
                logObj.timestamp = (long) aResult.get("logs.timestamp");
                logObj.user_exercise_id = (int) aResult.get("user_exercise_id");
                data.add(logObj);
            }
        }
        return this;
    }
}
