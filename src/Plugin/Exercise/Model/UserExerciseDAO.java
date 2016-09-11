package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.UserExerciseObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class UserExerciseDAO extends Model {
    @Override
    protected Object setData(Map result) {
        UserExerciseObj userExerciseObj = new UserExerciseObj();
        userExerciseObj.account_id = result.getInt("user_exercises.account_id");
        userExerciseObj.exercise_id = result.getInt("user_exercises.exercise_id");
        userExerciseObj.id = result.getInt("user_exercises.id");
        return userExerciseObj;
    }

    public UserExerciseDAO getUserExercises(int account_id) {
        make.add(account_id);
        setGet(SQL.make("SELECT * FROM user_exercises WHERE account_id=?", make.toArray()));
        return this;
    }

    public UserExerciseDAO getUserExercise(int account_id, int exercise_id) {
        make.add(account_id);
        make.add(exercise_id);
        setGet(SQL.make("SELECT * FROM user_exercises WHERE account_id=? AND exercise_id=?", make.toArray()));
        return this;
    }

    public UserExerciseDAO post(int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("exercise_id"));
        setPost(SQL.make("INSERT INTO user_exercises (account_id, exercise_id) VALUES (?, ?)", make.toArray()));
        return this;
    }

    public UserExerciseDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(id);
        setPut(SQL.make("UPDATE user_exercises SET exercise_id=? WHERE id=?", make.toArray()));
        return this;
    }

    public UserExerciseDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM user_exercises WHERE id=?", make.toArray()));
        return this;
    }
}
