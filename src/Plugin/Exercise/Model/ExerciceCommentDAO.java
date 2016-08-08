package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseCommentObj;
import org.json.JSONObject;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCommentDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseCommentObj exerciseCommentObj = new ExerciseCommentObj();
        exerciseCommentObj.account_id = result.getInt("account_id");
        exerciseCommentObj.content = result.getString("content");
        exerciseCommentObj.create_timestamp = result.getLong("create_timestamp");
        exerciseCommentObj.exercice_id = result.getInt("exercice_id");
        exerciseCommentObj.id = result.getInt("id");
        exerciseCommentObj.modify_timestamp = result.getLong("modify_timestamp");
        return exerciseCommentObj;
    }

    public ExerciceCommentDAO getExerciceComments(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT * FROM exercices_comments WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO post(String socket, int account_id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(account_id);
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO exercices_comments (exercice_id, account_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE exercices_comments SET exercice_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO delete(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercices_comments WHERE id=?", make.toArray()));
        return this;
    }
}