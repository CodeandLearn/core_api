package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.CodeTemplateObj;
import Plugin.Exercise.Obj.ExerciseModerationObj;
import Plugin.Exercise.Obj.ExerciseObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class ExerciseDAO extends Model {
    @Override
    protected Object setData(Map result) {
        ExerciseObj exerciseObj = new ExerciseObj();
        exerciseObj.account_id = result.getInt("exercises.account_id");
        exerciseObj.course_id = result.getInt("exercises.course_id");
        exerciseObj.grade_max = result.getInt("exercises.grade_max");
        exerciseObj.id = result.getInt("exercises.id");
        exerciseObj.instruction = result.getString("exercises.instruction");
        exerciseObj.title = result.getString("exercises.title");
        exerciseObj.moderation = new ExerciseModerationObj();
        exerciseObj.codes = new ArrayList<CodeTemplateObj>();
        return exerciseObj;
    }

    protected void setGet(String request, int flag) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (Map result : sql.getResultSet()) {
            Object ret = setData(result);
            if (ret != null) {
                ExerciseObj r = (ExerciseObj) ret;
                r.moderation = (ExerciseModerationObj) new ExerciseModerationDAO().getExerciseModeration(r.id).getData().get(0);
                if (flag > 0)
                    for (Object item : new CodeTemplateDAO().getTemplates(r.id).getData())
                        r.codes.add((CodeTemplateObj) item);
                else
                    r.codes = null;
                data.add(r);
            }
        }
    }

    public ExerciseDAO getCourseExercise(int course_id) {
        make.add(course_id);
        setGet(SQL.make("SELECT * FROM exercises WHERE course_id=?", make.toArray()), 0);
        return this;
    }

    public ExerciseDAO getExerciseById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM exercises WHERE id=?", make.toArray()), 1);
        return this;
    }

    public ExerciseDAO getExercises(String socket) {
        setGet("SELECT * FROM exercises");
        return this;
    }

    public ExerciseDAO post(int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("course_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("instruction"));
        make.add(jsonObject.getInt("grade_max"));
        setPost(SQL.make("INSERT INTO exercises (account_id, course_id, title, instruction, grade_max) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        new ExerciseModerationDAO().generate(this.id);
        return this;
    }

    public ExerciseDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("instruction"));
        make.add(jsonObject.getInt("grade_max"));
        make.add(id);
        setPut(SQL.make("UPDATE exercises SET title=?, instruction=?, grade_max=? WHERE id=?", make.toArray()));
        return this;
    }

    public ExerciseDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM exercises WHERE id=?", make.toArray()));
        return this;
    }
}
