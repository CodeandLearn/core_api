package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Exercise.Obj.ScriptObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ScriptDAO extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            ScriptObj scriptObj = new ScriptObj();
            scriptObj.content = (String) aResult.get("content");
            scriptObj.create_timestamp = (Long) aResult.get("create_timestamp");
            scriptObj.exercise_id = (Integer) aResult.get("exercice_id");
            scriptObj.id = (Integer) aResult.get("id");
            scriptObj.modify_timestamp = (Long) aResult.get("modify_timestamp");
            data.add(scriptObj);
        }
    }

    public ScriptDAO getExerciceScript(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT id, exercice_id, content, create_timestamp, modify_timestamp FROM scripts WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ScriptDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(socket, SQL.make("INSERT INTO scripts (exercice_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ScriptDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE scripts SET exercice_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ScriptDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM scripts WHERE id=?", make.toArray()));
        return this;
    }
}