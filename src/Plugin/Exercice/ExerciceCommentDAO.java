package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.CodeObj;
import Obj.ExerciseObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCommentDAO extends Model {
    private final static String SQL_get = "SELECT id, exercice_id, account_id, content, exercices_comments.create_timestamp, exercices_comments.modify_timestamp FROM 'exercices_comments' where exercice_id = ?";
    private final static String SQL_del = "DELETE * FROM 'exercices_comments' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'exercices_comments' (exercice_id, account_id, content, create_timestamp, modify_timestamp) VALUES (?,?,?,?,?)";
    private final static String SQL_upd = "UPDATE 'exercices_comments' set user_exercice_id=?, account_id, content=?, create_timestamp=?,  modifiy_timestamp=? WHERE id=?";

    public ExerciceCommentDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getInt("account_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("create_timestamp"));
        values.add(jsonObject.getLong("modify_timestamp"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        return this;
    }

    public ExerciceCommentDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("exercice_id"));
        values.add(jsonObject.getInt("account_id"));
        values.add(jsonObject.getString("content"));
        values.add(jsonObject.getLong("create_timestamp"));
        values.add(jsonObject.getLong("modify_timestamp"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        return this;
    }

    public ExerciceCommentDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        return this;
    }

    public ExerciceCommentDAO getExerciceComments(String socket, int exercice_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(exercice_id)));
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : sql.getResultSet()) {
                ExerciseObj exerciseObj = new ExerciseObj();
                exerciseObj.title = (String) aResult.get("title");
                exerciseObj.instruction = (String) aResult.get("instruction");
                exerciseObj.id = (int) aResult.get("id");
                exerciseObj.grade_max = (int) aResult.get("grade_max");
                exerciseObj.account_id = (int) aResult.get("account_id");
                exerciseObj.course_id = (int) aResult.get("course_id");
                data.add(exerciseObj);
            }
        }
        return this;
    }
}