package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseCommentObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseCommentDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseCommentObj exerciseCommentObj = new ExerciseCommentObj();
        exerciseCommentObj.account_id = result.getInt("exercises_comments.account_id");
        exerciseCommentObj.content = result.getString("exercises_comments.content");
        exerciseCommentObj.create_timestamp = result.getLong("exercises_comments.create_timestamp");
        exerciseCommentObj.exercise_id = result.getInt("exercises_comments.exercise_id");
        exerciseCommentObj.id = result.getInt("exercises_comments.id");
        exerciseCommentObj.modify_timestamp = result.getLong("exercises_comments.modify_timestamp");
        return exerciseCommentObj;
    }

    public ExerciseCommentDAO getExerciseComments(int exercise_id) {
        make.add(exercise_id);
        setGet(SQL.make("SELECT * FROM exercises_comments WHERE exercise_id=?", make.toArray()));
        return this;
    }

    public ExerciseCommentDAO post(int account_id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(account_id);
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO exercises_comments (exercise_id, account_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciseCommentDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE exercises_comments SET exercise_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseCommentDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercises_comments WHERE id=?", make.toArray()));
        return this;
    }
}