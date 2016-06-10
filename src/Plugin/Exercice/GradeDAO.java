package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.GradeObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class GradeDAO extends Model {
    private final static String SQL_get = "SELECT id, user_exercice_id, grades.value, grades.timestamp FROM 'grades' where user_exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'grades' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'grades' (user_exercice_id, grades.value, grades.timestamp) VALUES (?,?,?)";
    private final static String SQL_upd = "UPDATE 'grades' set user_exercice_id=?, grades.value=?, grades.timestamp=? WHERE id=?";

    public GradeDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("user_exercice_id"));
        values.add(jsonObject.getString("grade.value"));
        values.add(jsonObject.getLong("grade.timestamp"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        return this;
    }

    public GradeDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("user_exercice_id"));
        values.add(jsonObject.getString("grade.value"));
        values.add(jsonObject.getLong("grade.timestamp"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        return this;
    }

    public GradeDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        return this;
    }

    public GradeDAO getGrade(String socket, int user_exercice_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(user_exercice_id)));
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                GradeObj gradeObj = new GradeObj();
                gradeObj.id = (int) aResult.get("id");
                gradeObj.timestamp = (long) aResult.get("grade.timestamp");
                gradeObj.user_exercise_id = (int) aResult.get("user_exercise_id");
                data.add(gradeObj);
            }
        }
        return this;
    }
}
