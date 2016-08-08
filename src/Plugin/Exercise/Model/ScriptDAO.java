package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ScriptObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ScriptDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ScriptObj scriptObj = new ScriptObj();
        scriptObj.content = result.getString("content");
        scriptObj.create_timestamp = result.getLong("create_timestamp");
        scriptObj.exercice_id = result.getInt("exercice_id");
        scriptObj.id = result.getInt("id");
        scriptObj.modify_timestamp = result.getLong("modify_timestamp");
        return scriptObj;
    }

    public ScriptDAO getExerciceScript(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT * FROM scripts WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ScriptDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO scripts (exercice_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ScriptDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE scripts SET exercice_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ScriptDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM scripts WHERE id=?", make.toArray()));
        return this;
    }
}