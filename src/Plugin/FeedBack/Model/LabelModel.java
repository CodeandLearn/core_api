package Plugin.FeedBack.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.FeedBack.Obj.FeedbackLabelObj;
import org.json.JSONObject;

/**
 * Created by Sheol on 01/12/2016.
 */
public class LabelModel extends Model {
    @Override
    protected Object setData(Map result) {
        FeedbackLabelObj feedbackLabelObj = new FeedbackLabelObj();
        feedbackLabelObj.power = result.getInt("feedback_labels.power");
        feedbackLabelObj.position = result.getInt("feedback_labels.position");
        feedbackLabelObj.name = result.getString("feedback_labels.name");
        feedbackLabelObj.id = result.getInt("feedback_labels.id");
        feedbackLabelObj.color = result.getString("feedback_labels.color");
        return feedbackLabelObj;
    }

    public LabelModel getLabels() {
        setGet("SELECT * FROM feedback_labels");
        return this;
    }

    public LabelModel getLabelById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM feedback_labels WHERE id=?", make.toArray()));
        return this;
    }

    public LabelModel postLabel(JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getInt("power"));
        make.add(jsonObject.getInt("position"));
        make.add(jsonObject.getString("color"));
        setPost(SQL.make("INSERT INTO feedback_labels (name, power, position, color) VALUES (?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public LabelModel putLabel(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getInt("power"));
        make.add(jsonObject.getInt("position"));
        make.add(jsonObject.getString("color"));
        make.add(id);
        setPut(SQL.make("UPDATE feedback_labels SET name=?, power=?, position=?, color=?", make.toArray()));
        return this;
    }

    public LabelModel deleteLabel(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM feedback_labels WHERE id=?", make.toArray()));
        return this;
    }
}
