package Plugin.Exercise.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Exercise.Obj.CodeTemplateObj;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by moran on 9/1/2016.
 */
public class CodeTemplateDAO extends Model {
    protected Object setData(Map result) {
        CodeTemplateObj ctObj = new CodeTemplateObj();
        ctObj.id = result.getInt("code_templates.id");
        ctObj.exercise_id = result.getInt("code_templates.exercise_id");
        ctObj.file_name = result.getString("code_templates.file_name");
        ctObj.content = result.getString("code_templates.content");
        return ctObj;
    }

    public CodeTemplateDAO getTemplates(int exercise_id) {
        make.add(exercise_id);
        setGet(SQL.make("SELECT * FROM code_templates WHERE exercise_id=?", make.toArray()));
        return this;
    }

    public CodeTemplateDAO post(JSONObject jsonObject) {
        make.add(jsonObject.getInt("exercise_id"));
        make.add(jsonObject.getString("file_name"));
        make.add(jsonObject.getString("content"));
        setPost(SQL.make("INSERT INTO code_templates (exercise_id, file_name, content) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public CodeTemplateDAO post(JSONObject jsonObject, int e_id) {
        make.add(e_id);
        make.add(jsonObject.getString("file_name"));
        make.add(jsonObject.getString("content"));
        setPost(SQL.make("INSERT INTO code_templates (exercise_id, file_name, content) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }


    public CodeTemplateDAO update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("user_exercise_id"));
        make.add(jsonObject.getString("file_name"));
        make.add(jsonObject.getString("content"));
        make.add(id);
        setPut(SQL.make("UPDATE code_templates SET exercise_id=?, file_name=?, content=? WHERE id=?", make.toArray()));
        return this;
    }

    public CodeTemplateDAO delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM code_templates WHERE id=?", make.toArray()));
        return this;
    }

    public CodeTemplateDAO deleteAll(int exercise_id) {
        make.add(exercise_id);
        setDelete(SQL.make("DELETE FROM code_templates WHERE exercise_id=?", make.toArray()));
        return this;
    }

}
