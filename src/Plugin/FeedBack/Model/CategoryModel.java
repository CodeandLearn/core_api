package Plugin.FeedBack.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.FeedBack.Obj.FeedbackCategoryObj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class CategoryModel extends Model {
    @Override
    protected Object setData(Map result) {
        FeedbackCategoryObj categoryObj = new FeedbackCategoryObj();
        categoryObj.description = result.getString("feedback_category.description");
        categoryObj.feedback_icon_id = result.getInt("feedback_category.feedback_icon_id");
        categoryObj.id = result.getInt("feedback_category.id");
        categoryObj.name = result.getString("feedback_category.name");
        categoryObj.position = result.getInt("feedback_category.position");
        categoryObj.feedback_icon.id = result.getInt("feedback_icons.id");
        categoryObj.feedback_icon.path = result.getString("feedback_icons.path");
        return null;
    }

    public CategoryModel getCategories() {
        setGet("SELECT * FROM feedback_category, feedback_icons WHERE feedback_category.feedback_icon_id=feedback_icon.id");
        return this;
    }

    public CategoryModel getCategoriesById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM feedback_category, feedback_icons WHERE feedback_category.feedback_icon_id=feedback_icon.id AND feedback_category.id=?", make.toArray()));
        return this;
    }
}
