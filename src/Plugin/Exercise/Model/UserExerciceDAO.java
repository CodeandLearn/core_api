package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.UserExerciseObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class UserExerciceDAO extends Model {
    @Override
    protected Object setData(Map result) {
        UserExerciseObj userExerciseObj = new UserExerciseObj();
        userExerciseObj.account_id = result.getInt("account_id");
        userExerciseObj.exercice_id = result.getInt("exercice_id");
        userExerciseObj.id = result.getInt("id");
        return userExerciseObj;
    }

    public UserExerciceDAO getUserExercices(String socket, int account_id) {
        make.add(account_id);
        setGet(SQL.make("SELECT * FROM user_exercises WHERE account_id=?", make.toArray()));
        return this;
    }

    public UserExerciceDAO getUserExercice(String socket, int account_id, int exercice_id) {
        make.add(account_id);
        make.add(exercice_id);
        setGet(SQL.make("SELECT * FROM user_exercises WHERE account_id=? AND exercice_id=?", make.toArray()));
        return this;
    }

    public UserExerciceDAO post(String socket, int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("exercice_id"));
        setPost(SQL.make("INSERT INTO user_exercises (account_id, exercice_id) VALUES (?, ?)", make.toArray()));
        return this;
    }

    public UserExerciceDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(id);
        setPut(SQL.make("UPDATE user_exercises SET exercice_id=? WHERE id=?", make.toArray()));
        return this;
    }

    public UserExerciceDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM user_exercises WHERE id=?", make.toArray()));
        return this;
    }
}
