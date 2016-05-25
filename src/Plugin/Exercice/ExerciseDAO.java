package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Obj.ExerciseObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseDAO extends Model {
    private final static String SQL_get = "SELECT exercices.id, exercices.account_id, exercices.course_id, exercices.title, exercices.instruction, exercices.grade_max FROM 'exercices' where course_id = ?";
    private final static String SQL_get_ALL = "SELECT exercices.id, exercices.account_id, exercices.course_id, exercices.title, exercices.instruction, exercices.grade_max FROM 'exercices'";
    private final static String SQL_getId = "SELECT exercices.id, exercices.account_id, exercices.course_id, exercices.title, exercices.instruction, exercices.grade_max FROM 'exercices' where id = ?";
    private final static String SQL_del = "DELETE * FROM 'exercices' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'exercices' (account_id, course_id, title, instruction, grade_max) VALUES (?,?,?,?,?)";
    private final static String SQL_upd = "UPDATE 'exercices' set account_id=?, course_id=?, title=?, instruction=?, grade_max=? WHERE id=?";


    public ExerciseDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("account_id"));
        values.add(jsonObject.getInt("course_id"));
        values.add(jsonObject.getString("title"));
        values.add(jsonObject.getString("instruction"));
        values.add(jsonObject.getInt("grade_max"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciseDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("account_id"));
        values.add(jsonObject.getInt("course_id"));
        values.add(jsonObject.getString("title"));
        values.add(jsonObject.getString("instruction"));
        values.add(jsonObject.getInt("grade_max"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        setNoReturnValue(socket);
        return this;
    }

    public ExerciseDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        setExerciseData(socket, sql.getResultSet());
        return this;
    }

    public ExerciseDAO getCourseExercise(String socket, int course_id) {
        SQLite sql = new SQLite(SQL_get.replace("?", String.valueOf(course_id)));
        sql.select();
        setExerciseData(socket, sql.getResultSet());
        return this;
    }

    public ExerciseDAO getExerciseById(String socket, int id) {
        SQLite sql = new SQLite(SQL_getId.replace("?", String.valueOf(id)));
        sql.select();
        setExerciseData(socket, sql.getResultSet());
        return this;
    }

    public ExerciseDAO getExercises(String socket) {
        SQLite sql = new SQLite(SQL_get_ALL);
        sql.select();
        setExerciseData(socket, sql.getResultSet());
        return this;
    }

    private void setExerciseData(String socket, ArrayList<HashMap<String, Object>> result) {
        if (result.size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : result) {
                ExerciseObj exerciseObj = new ExerciseObj();
                exerciseObj.account_id = (int) aResult.get("account_id");
                exerciseObj.course_id = (int) aResult.get("course_id");
                exerciseObj.grade_max = (int) aResult.get("grade_max");
                exerciseObj.id = (int) aResult.get("id");
                exerciseObj.instruction = (String) aResult.get("instruction");
                exerciseObj.title = (String) aResult.get("title");
                data.add(exerciseObj);
            }
        }
    }
}
