package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.CodeObj;
import Plugin.ServerCom.ExerciseIds;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class CodeDAO extends Model {
    @Override
    protected Object setData(Map result) {
        CodeObj codeObj = new CodeObj();
        codeObj.content = result.getString("codes.content");
        codeObj.create_timestamp = result.getLong("codes.create_timestamp");
        codeObj.id = result.getInt("codes.id");
        codeObj.modify_timestamp = result.getLong("codes.modify_timestamp");
        codeObj.user_exercise_id = result.getInt("codes.user_exercise_id");
        codeObj.name = result.getString("codes.name");
        return codeObj;
    }

    public CodeDAO getCodes(int user_exercise_id) {
        make.add(user_exercise_id);
        setGet(SQL.make("SELECT * FROM codes WHERE user_exercise_id=?", make.toArray()));
        return this;
    }

    public CodeDAO post(JSONObject jsonObject) {
        if (jsonObject.has("codes")) {
            JSONArray array = (JSONArray) jsonObject.get("codes");
            int id = 0;
            for (int n = 0; n < array.length(); ++n) {
                JSONObject object = array.getJSONObject(n);
                id = object.getInt("user_exercise_id");
                make.add(id);
                make.add(object.getString("content"));
                make.add(getTimestamp());
                make.add(getTimestamp());
                make.add(object.getString("name"));
                setPost(SQL.make("INSERT INTO codes (user_exercise_id, content, create_timestamp, modify_timestamp, name) VALUES (?, ?, ?, ?,?)", make.toArray()));
                make.clear();
            }
            if (!ExerciseIds.getInstance().inQueue(id)) {
                ExerciseIds.getInstance().addId(id);
            }
        }
        return this;
    }

    public CodeDAO update(int user_exercise_id, JSONObject jsonObject) {
        if (jsonObject.has("codes")) {
            JSONArray array = (JSONArray) jsonObject.get("codes");
            for (int n = 0; n < array.length(); ++n) {
                JSONObject object = array.getJSONObject(n);
                System.err.println(array.toString());
                make.add(user_exercise_id);
                make.add(object.getString("content"));
                make.add(getTimestamp());
                make.add(object.getString("name"));
                make.add(object.getInt("id"));
                setPut(SQL.make("UPDATE codes SET user_exercise_id=?, content=?, modify_timestamp=?, name=? WHERE id=?", make.toArray()));
                make.clear();
            }
            if (!ExerciseIds.getInstance().inQueue(user_exercise_id)) {
                ExerciseIds.getInstance().addId(user_exercise_id);
            }
        }
        return this;
    }

    public CodeDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM codes WHERE id=?", make.toArray()));
        return this;
    }
}
