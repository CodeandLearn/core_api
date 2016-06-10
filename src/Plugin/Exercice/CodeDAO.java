package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.CodeObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class CodeDAO extends Model {
    private final static String SQL_lst = "SELECT id, user_exercice_id, content, create_timestamp, modify_timestamp FROM 'codes' where user_exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'codes' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'codes' (user_exercice_id, content, create_timestamp, modify_timestamp) VALUES (?,?,?,?)";
    private final static String SQL_upd = "UPDATE 'codes' set user_exercice_id=?, content=?, create_timestamp=?, modifiy_timestamp=? WHERE id=?";

    public CodeDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("user_exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("create_timestamp"));
        values.add(jsonObject.getLong("modify_timestamp"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        return this;
    }

    public CodeDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("user_exercice_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("create_timestamp"));
        values.add(jsonObject.getLong("modify_timestamp"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        return this;
    }

    public CodeDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        return this;
    }

    public CodeDAO getCodes(String socket, int user_exercice_id) {
        SQLite sql = new SQLite(SQL_lst.replace("?", String.valueOf(user_exercice_id)));
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                CodeObj codeObj = new CodeObj();
                codeObj.content = (String) aResult.get("content");
                codeObj.create_timestamp = (long) aResult.get("create_timestamp");
                codeObj.id = (int) aResult.get("id");
                codeObj.modify_timestamp = (long) aResult.get("modify_timestamp");
                codeObj.user_exercise_id = (int) aResult.get("user_exercice_id");
                data.add(codeObj);
            }
        }
        return this;
    }
}
