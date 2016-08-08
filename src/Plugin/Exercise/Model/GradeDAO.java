package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.GradeObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class GradeDAO extends Model {
    @Override
    protected Object setData(Map result) {
        GradeObj gradeObj = new GradeObj();
        gradeObj.id = result.getInt("id");
        gradeObj.timestamp = result.getLong("timestamp");
        gradeObj.user_exercice_id = result.getInt("user_exercice_id");
        gradeObj.value = result.getInt("value");
        return gradeObj;
    }

    public GradeDAO getGrade(String socket, int account_id, int user_exercice_id) {
        make.add(user_exercice_id);
        setGet(SQL.make("SELECT * FROM grades WHERE user_exercice_id=?", make.toArray()));
        return this;
    }

    public GradeDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getInt("value"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO grades (user_exercice_id, value, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public GradeDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getInt("value"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE grades SET user_exercice_id=?, value=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public GradeDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM grades WHERE id=?", make.toArray()));
        return this;
    }
}
