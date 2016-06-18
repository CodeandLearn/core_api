package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Exercise.Obj.LogObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class LogDAO extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            LogObj logObj = new LogObj();
            logObj.content = (String) aResult.get("content");
            logObj.id = (Integer) aResult.get("id");
            logObj.timestamp = (Long) aResult.get("timestamp");
            logObj.user_exercise_id = (Integer) aResult.get("user_exercice_id");
            data.add(logObj);
        }
    }

    public LogDAO getLog(String socket, int account_id, int user_exercice_id) {
        make.add(user_exercice_id);
        setGet(SQL.make("SELECT id, user_exercice_id, content, logs.timestamp FROM logs WHERE user_exercice_id=?", make.toArray()));
        return this;
    }

    public LogDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        setPost(socket, SQL.make("INSERT INTO logs (user_exercice_id, content, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public LogDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE logs SET user_exercice_id=?, content=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public LogDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM logs WHERE id=?", make.toArray()));
        return this;
    }
}
