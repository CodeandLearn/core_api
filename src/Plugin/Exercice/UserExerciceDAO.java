package Plugin.Exercice;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Plugin.Exercice.Obj.UserExerciseObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class UserExerciceDAO extends Model {
    private final static String SQL_get = "SELECT user_exercises.id, user_exercises.account_id, user_exercises.exercice_id  FROM 'user_exercises' where account_id = ? AND exercice_id = ?";
    private final static String SQL_lst = "SELECT user_exercises.id, user_exercises.account_id, user_exercises.exercice_id  FROM 'user_exercises' where account_id = ?";
    private final static String SQL_del = "DELETE * FROM 'user_exercises' WHERE id = ?";
    private final static String SQL_ins = "INSERT INTO 'user_exercises' (account_id, exercice_id) VALUES (?,?)";
    private final static String SQL_upd = "UPDATE 'user_exercises' set account_id=?, exercice_id=? WHERE id=?";

    public UserExerciceDAO post(String socket, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("account_id"));
        values.add(jsonObject.getString("exercice_id"));
        SQLite sql = new SQLite(SQL.make(SQL_ins, values.toArray()));
        sql.insert();
        return this;
    }

    public UserExerciceDAO update(String socket, int id, JSONObject jsonObject) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(jsonObject.getInt("account_id"));
        values.add(jsonObject.getString("exercice_id"));
        values.add(id);
        SQLite sql = new SQLite(SQL.make(SQL_upd, values.toArray()));
        sql.update();
        return this;
    }

    public UserExerciceDAO delete(String socket, int id) {
        SQLite sql = new SQLite(SQL_del.replace("?", String.valueOf(id)));
        sql.delete();
        return this;
    }

    public UserExerciceDAO getUserExercices(String socket, int account_id) {
        SQLite sql = new SQLite(SQL_lst.replace("?", String.valueOf(account_id)));
        sql.select();
        setUserExercisesData(socket, sql.getResultSet());
        return this;
    }

    public UserExerciceDAO getUserExercice(String socket, int account_id, int exercice_id) {
        ArrayList<Object> values = new ArrayList<>();
        values.add(account_id);
        values.add(exercice_id);
        SQLite sql = new SQLite(SQL.make(SQL_get, values.toArray()));
        sql.select();
        setUserExercisesData(socket, sql.getResultSet());
        return this;
    }

    private void setUserExercisesData(String socket, ArrayList<HashMap<String, Object>> result) {
        if (result.size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (HashMap<String, Object> aResult : result) {
                UserExerciseObj userExerciseObj = new UserExerciseObj();
                userExerciseObj.account_id = (int) aResult.get("account_id");
                userExerciseObj.exercise_id = (int) aResult.get("exercise_id");
                userExerciseObj.id = (int) aResult.get("id");
                data.add(userExerciseObj);
            }
        }
    }
}
