package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Exercise.Obj.UserExerciseObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class UserExerciceDAO extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            UserExerciseObj userExerciseObj = new UserExerciseObj();
            userExerciseObj.account_id = (Integer) aResult.get("account_id");
            userExerciseObj.exercise_id = (Integer) aResult.get("exercice_id");
            userExerciseObj.id = (Integer) aResult.get("id");
            data.add(userExerciseObj);
        }
    }

    public UserExerciceDAO getUserExercices(String socket, int account_id) {
        make.add(account_id);
        setGet(SQL.make("SELECT user_exercises.id, user_exercises.account_id, user_exercises.exercice_id  FROM user_exercises WHERE account_id=?", make.toArray()));
        return this;
    }

    public UserExerciceDAO getUserExercice(String socket, int account_id, int exercice_id) {
        make.add(account_id);
        make.add(exercice_id);
        setGet(SQL.make("SELECT user_exercises.id, user_exercises.account_id, user_exercises.exercice_id FROM user_exercises WHERE account_id=? AND exercice_id=?", make.toArray()));
        return this;
    }

    public UserExerciceDAO post(String socket, int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("exercice_id"));
        setPost(socket, SQL.make("INSERT INTO user_exercises (account_id, exercice_id) VALUES (?, ?)", make.toArray()));
        return this;
    }

    public UserExerciceDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE user_exercises SET exercice_id=? WHERE id=?", make.toArray()));
        return this;
    }

    public UserExerciceDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM user_exercises WHERE id=?", make.toArray()));
        return this;
    }
}
