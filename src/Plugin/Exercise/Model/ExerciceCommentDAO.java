package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Exercise.Obj.ExerciseObj;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciceCommentDAO extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
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

    public ExerciceCommentDAO getExerciceComments(String socket, int exercice_id) {
        make.add(exercice_id);
        setGet(SQL.make("SELECT id, exercice_id, account_id, content, exercices_comments.create_timestamp, exercices_comments.modify_timestamp FROM exercices_comments WHERE exercice_id=?", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO post(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getInt("account_id"));
        make.add(jsonObject.getString("content"));
        make.add(jsonObject.getLong("create_timestamp"));
        make.add(jsonObject.getLong("modify_timestamp"));
        setPost(socket, SQL.make("INSERT INTO exercices_comments (exercice_id, account_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO update(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercice_id"));
        make.add(jsonObject.getInt("account_id"));
        make.add(jsonObject.getString("content"));
        make.add(jsonObject.getLong("create_timestamp"));
        make.add(jsonObject.getLong("modify_timestamp"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE exercices_comments SET user_exercice_id=?, account_id, content=?, create_timestamp=?, modifiy_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciceCommentDAO delete(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM exercices_comments WHERE id=?", make.toArray()));
        return this;
    }
}