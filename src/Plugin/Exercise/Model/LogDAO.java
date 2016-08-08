package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.LogObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class LogDAO extends Model {
    @Override
    protected Object setData(Map result) {
        LogObj logObj = new LogObj();
        logObj.content = result.getString("content");
        logObj.id = result.getInt("id");
        logObj.timestamp = result.getLong("timestamp");
        logObj.user_exercice_id = result.getInt("user_exercice_id");
        return logObj;
    }

    public LogDAO getLog(String socket, int account_id, int user_exercice_id) {
        make.add(user_exercice_id);
        setGet(SQL.make("SELECT * FROM logs WHERE user_exercice_id=?", make.toArray()));
        return this;
    }

    public LogDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO logs (user_exercice_id, content, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public LogDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE logs SET user_exercice_id=?, content=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public LogDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM logs WHERE id=?", make.toArray()));
        return this;
    }
}
