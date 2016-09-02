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
        gradeObj.id = result.getInt("grades.id");
        gradeObj.timestamp = result.getLong("grades.timestamp");
        gradeObj.user_exercise_id = result.getInt("grades.user_exercise_id");
        gradeObj.value = result.getInt("grades.value");
        return gradeObj;
    }

    public GradeDAO getGrade(int user_exercise_id) {
        make.add(user_exercise_id);
        setGet(SQL.make("SELECT * FROM grades WHERE user_exercise_id=?", make.toArray()));
        return this;
    }

    public GradeDAO post(JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercise_id"));
        make.add(jsonObject.getInt("value"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO grades (user_exercise_id, value, timestamp) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public GradeDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercise_id"));
        make.add(jsonObject.getInt("value"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE grades SET user_exercise_id=?, value=?, timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public GradeDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM grades WHERE id=?", make.toArray()));
        return this;
    }
}
