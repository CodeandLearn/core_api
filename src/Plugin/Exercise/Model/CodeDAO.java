package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Exercise.Obj.CodeObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class CodeDAO extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            CodeObj codeObj = new CodeObj();
            codeObj.content = (String) result.get("content");
            codeObj.create_timestamp = (Long) result.get("create_timestamp");
            codeObj.id = (Integer) result.get("id");
            codeObj.modify_timestamp = (Long) result.get("modify_timestamp");
            codeObj.user_exercise_id = (Integer) result.get("user_exercice_id");
            data.add(codeObj);
        }
    }

    public CodeDAO getCodes(String socket, int account_id, int user_exercice_id) {
        make.add(user_exercice_id);
        setGet(SQL.make("SELECT id, user_exercice_id, content, create_timestamp, modify_timestamp FROM codes WHERE user_exercice_id=?", make.toArray()));
        return this;
    }

    public CodeDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(socket, SQL.make("INSERT INTO codes (user_exercice_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public CodeDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE codes SET user_exercice_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public CodeDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM codes WHERE id=?", make.toArray()));
        return this;
    }
}
