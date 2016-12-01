package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumCategoryObj;

/**
 * Created by Sheol on 30/11/2016.
 */
public class CategoryModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumCategoryObj forumCategoryObj = new ForumCategoryObj();
        forumCategoryObj.icon_id = result.getInt("forum_categories.icon_id");
        forumCategoryObj.id = result.getInt("forum_categories.id");
        forumCategoryObj.position = result.getInt("forum_categories.position");
        forumCategoryObj.title = result.getString("forum_categories.title");
        forumCategoryObj.icon.id = result.getInt("forum_icons.id");
        forumCategoryObj.icon.path = result.getString("forum_icons.path");
        return forumCategoryObj;
    }

    public CategoryModel getCategories() {
        setGet("SELECT * FROM forum_categories, forum_icons WHERE forum_categories.icon_id=forum_icons.id");
        return this;
    }

    public CategoryModel getCategoriesOrderByPosition() {
        setGet("SELECT * FROM forum_categories, forum_icons WHERE forum_categories.icon_id=forum_icons.id ORDER BY forum_categories.position ASC");
        return this;
    }

    public CategoryModel getCategoryById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_categories, forum_icons WHERE forum_categories.icon_id=forum_icons.id AND forum_categories.id=?", make.toArray()));
        return this;
    }
}
