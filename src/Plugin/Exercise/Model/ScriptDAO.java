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
        scriptObj.content = result.getString("scripts.content");
        scriptObj.create_timestamp = result.getLong("scripts.create_timestamp");
        scriptObj.exercise_id = result.getInt("scripts.exercise_id");
        scriptObj.id = result.getInt("scripts.id");
        scriptObj.modify_timestamp = result.getLong("scripts.modify_timestamp");
        return scriptObj;
    }

    public ScriptDAO getExerciseScript(int exercise_id) {
        make.add(exercise_id);
        setGet(SQL.make("SELECT * FROM scripts WHERE exercise_id=?", make.toArray()));
        return this;
    }

    public ScriptDAO post(JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO scripts (exercise_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ScriptDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE scripts SET exercise_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ScriptDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM scripts WHERE id=?", make.toArray()));
        return this;
    }

    public ScriptDAO deleteByExercise(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM scripts WHERE exercise_id=?", make.toArray()));
        return this;
    }

}