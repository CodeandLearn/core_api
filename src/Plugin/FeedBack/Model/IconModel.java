package Plugin.FeedBack.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.FeedBack.Obj.FeedbackIconObj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class IconModel extends Model {
    @Override
    protected Object setData(Map result) {
        FeedbackIconObj feedbackIconObj = new FeedbackIconObj();
        feedbackIconObj.path = result.getString("feedback_icons.path");
        feedbackIconObj.id = result.getInt("feedback_icons.id");
        return feedbackIconObj;
    }

    public IconModel getIcons() {
        setGet("SELECT * FROM feedback_icons");
        return this;
    }

    public IconModel getIconById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM feedback_icons WHERE id=?", make.toArray()));
        return this;
    }
}
