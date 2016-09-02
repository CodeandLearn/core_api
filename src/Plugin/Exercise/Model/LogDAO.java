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
        logObj.content = result.getString("logs.content");
        logObj.id = result.getInt("logs.id");
        logObj.timestamp = result.getLong("logs.timestamp");
        logObj.user_exercise_id = result.getInt("logs.user_exercise_id");
        return logObj;
    }

    public LogDAO getLog(int user_exercise_id) {
        make.add(user_exercise_id);
        setGet(SQL.make("SELECT * FROM logs WHERE user_exercise_id=?", make.toArray()));
        return this;
    }

    public LogDAO post(JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO logs (user_exercise_id, content, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public LogDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE logs SET user_exercise_id=?, content=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public LogDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM logs WHERE id=?", make.toArray()));
        return this;
    }
}
