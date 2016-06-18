package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseCommentObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCommentDAO extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> aResult : sql.getResultSet()) {
            ExerciseCommentObj exerciseCommentObj = new ExerciseCommentObj();
            exerciseCommentObj.account_id = (Integer) aResult.get("account_id");
            exerciseCommentObj.content = (String) aResult.get("content");
            exerciseCommentObj.create_timestamp = (Long) aResult.get("create_timestamp");
            exerciseCommentObj.exercise_id = (Integer) aResult.get("exercice_id");
            exerciseCommentObj.id = (Integer) aResult.get("id");
            exerciseCommentObj.modify_timestamp = (Long) aResult.get("modify_timestamp");
            data.add(exerciseCommentObj);
        }
    }

    public ExerciceCommentDAO getExerciceComments(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT id, exercice_id, account_id, content, exercices_comments.create_timestamp, exercices_comments.modify_timestamp FROM exercices_comments WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO post(String socket, int account_id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(account_id);
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(socket, SQL.make("INSERT INTO exercices_comments (exercice_id, account_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE exercices_comments SET exercice_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM exercices_comments WHERE id=?", make.toArray()));
        return this;
    }
}