package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Exercise.Obj.GradeObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class GradeDAO extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            GradeObj gradeObj = new GradeObj();
            gradeObj.id = (Integer) aResult.get("id");
            gradeObj.timestamp = (Long) aResult.get("timestamp");
            gradeObj.user_exercise_id = (Integer) aResult.get("user_exercice_id");
            gradeObj.value = (Integer) aResult.get("value");
            data.add(gradeObj);
        }
    }

    public GradeDAO getGrade(String socket, int account_id, int user_exercice_id) {
        make.add(user_exercice_id);
        setGet(SQL.make("SELECT id, user_exercice_id, grades.value, grades.timestamp FROM grades WHERE user_exercice_id=?", make.toArray()));
        return this;
    }

    public GradeDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getInt("value"));
        make.add(getTimestamp());
        setPost(socket, SQL.make("INSERT INTO grades (user_exercice_id, value, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public GradeDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercice_id"));
        make.add(jsonObject.getInt("value"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE grades SET user_exercice_id=?, value=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public GradeDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM grades WHERE id=?", make.toArray()));
        return this;
    }
}
