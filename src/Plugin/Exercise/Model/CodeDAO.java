package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.CodeObj;
import Plugin.ServerCom.ExerciseIds;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class CodeDAO extends Model {
    @Override
    protected Object setData(Map result) {
        CodeObj codeObj = new CodeObj();
        codeObj.content = result.getString("content");
        codeObj.create_timestamp = result.getLong("create_timestamp");
        codeObj.id = result.getInt("id");
        codeObj.modify_timestamp = result.getLong("modify_timestamp");
        codeObj.user_exercice_id = result.getInt("user_exercice_id");
        codeObj.name = result.getString("name");
        return codeObj;
    }

    public CodeDAO getCodes(String socket, int account_id, int user_exercice_id) {
        make.add(user_exercice_id);
        setGet(SQL.make("SELECT * FROM codes WHERE user_exercice_id=?", make.toArray()));
        return this;
    }

    public CodeDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        make.add(jsonObject.getString("name"));
        setPost(SQL.make("INSERT INTO codes (user_exercice_id, content, create_timestamp, modify_timestamp, name) VALUES (?, ?, ?, ?,?)", make.toArray()));
        ExerciseIds.getInstance().addId(jsonObject.getInt("user_exercice_id"));
        return this;
    }

    public CodeDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(jsonObject.getString("name"));
        make.add(id);
        setPut(SQL.make("UPDATE codes SET user_exercice_id=?, content=?, modify_timestamp=?, name=? WHERE id=?", make.toArray()));
        ExerciseIds.getInstance().addId(jsonObject.getInt("user_exercice_id"));
        return this;
    }

    public CodeDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM codes WHERE id=?", make.toArray()));
        return this;
    }
}
